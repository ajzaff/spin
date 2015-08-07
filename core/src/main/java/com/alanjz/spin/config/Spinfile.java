package com.alanjz.spin.config;

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

import com.alanjz.spin.Versioned;

/**
 * A configuration file for a Spin project.
 * The Spinfile is meant to be completely portable.
 * In other words, you can share your Spinfile with others
 * and it will automatically configure a project for you.
 *
 * Moreover, you can use Spinfiles to configure a
 * project template, where the Spinfile is tasked to
 * pull in all the required resources and settings
 * to make creating projects in Spin easier.
 */
public interface Spinfile extends Versioned {

  /**
   * A string to use as a project name
   * @return the project name string
   */
  String getProjectName();
}
