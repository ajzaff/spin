package com.alanjz.spin.util;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public final class ParserUtils {

  /**
   *
   */
  public static final Pattern TOKEN_PATTERN = Pattern.compile("\\S+");

  /**
   *
   */
  public static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");

  /**
   *
   * @param pattern
   * @param matcher
   */
  public static void usePattern(Pattern pattern, Matcher matcher) {
      if(matcher.pattern() != pattern) {
          matcher.usePattern(pattern);
      }
  }

  /**
   *
   * @param matcher
   * @return
   */
  public static boolean consumeWhitespace(Matcher matcher) {
      usePattern(WHITESPACE_PATTERN, matcher);
      return matcher.find();
  }

  /**
   *
   * @param matcher
   * @return
   */
  public static boolean consumeToken(Matcher matcher) {
      usePattern(TOKEN_PATTERN, matcher);
      return matcher.find();
  }
}
