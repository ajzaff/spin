package com.alanjz.spin.util.parser.config;

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

import com.alanjz.spin.config.Spinfile;
import com.alanjz.spin.peers.Peer;
import com.alanjz.spin.util.parser.Parser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

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
    Spinfile spinfile;
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

    for(int i=0; i < peers.length; i++)
      peers[i] = parsePeer(peersArray.getJSONObject(i));

    try {
      spinfile = new Spinfile(modelVersion, projectGroup, projectName, projectVersion, peers);
    }
    catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return spinfile;
  }

  /**
   *
   * @return
   */
  public Peer parsePeer(JSONObject jsonObject) {
    String id = jsonObject.getString("id");
    String name = jsonObject.getString("name");
    String contentRoot = jsonObject.getString("contentRoot");
    String cacheRoot = jsonObject.getString("cacheRoot");
    int parallelism = jsonObject.getInt("parallelism");
    int port = jsonObject.getInt("port");
    return new Peer(id, port, name, contentRoot, cacheRoot, parallelism);
  }
}