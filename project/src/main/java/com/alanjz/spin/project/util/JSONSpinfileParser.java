package com.alanjz.spin.project.util;

/*
    ____/ ___ \   /  __  \
   __  ) /__/ /  /  / /  /
 _____/  ____/__/__/ /__/  (c)
      __/

A P2P distributed compute and storage framework.
Copyright (C) 2015 Alan J. Zaffetti

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import com.alanjz.spin.project.Spinfile;
import com.alanjz.spin.peers.Peer;
import com.alanjz.spin.util.Parser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class JSONSpinfileParser implements Parser<Spinfile> {

  /**
   *
   */
  protected File file;

  /**
   *
   */
  protected JSONObject config;

  /**
   * @param file
   */
  public JSONSpinfileParser(File file) {
    setFile(file);
  }

  /**
   *
   * @return
   */
  protected File getFile() {
    return file;
  }

  /**
   *
   * @return
   */
  public JSONObject getConfig() {
    return config;
  }

  /**
   *
   * @param config
   */
  public void setConfig(JSONObject config) {
    this.config = config;
  }

  /**
   *
   * @param file
   */
  protected void setFile(File file) {
    this.file = file;
  }

  @Override
  public Spinfile parse() {
    StringBuilder stringBuilder;
    FileReader fileReader;
    String source;
    int c;

    try {
      fileReader = new FileReader(getFile().getAbsoluteFile());
      stringBuilder = new StringBuilder();
      while((c = fileReader.read()) != -1)
        stringBuilder.append((char) c);
      source = stringBuilder.toString();
    }
    catch (IOException e) {
      e.printStackTrace();
      return null;
    }

    setConfig(new JSONObject(source));
    String modelVersion = getConfig().getString("modelVersion");
    String projectGroup = getConfig().getString("projectGroup");
    String projectName = getConfig().getString("projectName");
    String projectVersion = getConfig().getString("projectVersion");

    JSONArray peersArray = getConfig().getJSONArray("peers");
    Peer[] peers = new Peer[peersArray.length()];

    for(int i=0; i < peers.length; i++) {
      peers[i] = parsePeer(peersArray.getJSONObject(i));
    }

    return new Spinfile(modelVersion, projectGroup, projectName, projectVersion, peers);
  }

  /**
   *
   * @return
   */
  public Peer parsePeer(JSONObject jsonObject) {
    String id = parseID(jsonObject, jsonObject.getString("id"));
    String name = jsonObject.getString("name");
    String contentRoot = jsonObject.getString("contentRoot");
    String cacheRoot = jsonObject.getString("cacheRoot");
    int parallelism = jsonObject.getInt("parallelism");
    int port = jsonObject.getInt("port");
    return new Peer(id, port, name, contentRoot, cacheRoot, parallelism, null);
  }

  /**
   *
   */
  static Pattern functionPattern = Pattern.compile("(\\w+)::(\\w+)\\((\\$?\\w*)\\)");

  static MessageDigest sha1MessageDigest;

  static {
    try {
      sha1MessageDigest = MessageDigest.getInstance("sha-1");
    }
    catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  public String digest64(MessageDigest md, String str) {
    return Base64.getEncoder().encodeToString(md.digest(str.getBytes()));
  }

  /**
   *
   * @param id
   * @return
   */
  protected String parseID(JSONObject obj, String id) throws IllegalArgumentException {
    Matcher matcher;

    matcher = functionPattern.matcher(id);
    if(matcher.matches()) {
      String ns, fn, arg;

      ns = matcher.group(1).toLowerCase();
      fn = matcher.group(2).toLowerCase();
      arg = matcher.group(3);
      switch(ns) {
        case "crypto":
          switch(fn) {
            case "sha1":
              if(arg.startsWith("$")) {
                String var = arg.substring(1);
                switch(var) {
                  case "name":
                    return digest64(sha1MessageDigest, obj.getString(var));
                  default:
                    throw new IllegalArgumentException("unrecognized field '" + var + "' near '" + id + "'");
                }
              }
              else {
                return digest64(sha1MessageDigest, arg);
              }
            default:
              throw new IllegalArgumentException("unrecognized function '" + fn + "' near '" + id + "'");
          }
        default:
          throw new IllegalArgumentException("unrecognized namespace '" + ns + "' near '" + id + "'");
      }
    }
    return id;
  }
}