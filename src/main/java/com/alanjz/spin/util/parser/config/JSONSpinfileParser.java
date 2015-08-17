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
import com.alanjz.spin.util.factory.config.SpinfileFactory;
import com.alanjz.spin.util.parser.Parser;

/**
 *
 */
public class JSONSpinfileParser implements Parser<Spinfile> {

  SpinfileFactory spinfileFactory;

  @Override
  public Spinfile parse() {
    return null;
  }
}
