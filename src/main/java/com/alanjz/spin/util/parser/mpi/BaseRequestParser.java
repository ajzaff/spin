package com.alanjz.spin.util.parser.mpi;

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

import com.alanjz.spin.mpi.Request;
import com.alanjz.spin.mpi.RequestVerb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Request parsing with URI parsing in accordance with RFC 2396.
 */
public class BaseRequestParser extends AbstractRequestParser {

  protected Pattern VERB_PATTERN = Pattern.compile("([A-Za-z][A-Za-z0-9]*)");

  /**
   * @param requestText
   */
  public BaseRequestParser(String requestText) {
    super(requestText);
  }

  @Override
  public Request parse() throws Exception {
    RequestVerb requestVerb;
    String requestText;
    Matcher matcher;
    String verbName;

    requestText = getRequestText();
    matcher = VERB_PATTERN.matcher(requestText);
    if(matcher.find()) {
      verbName = requestText.substring(matcher.start(), matcher.end());
    }

    return null;
  }
}
