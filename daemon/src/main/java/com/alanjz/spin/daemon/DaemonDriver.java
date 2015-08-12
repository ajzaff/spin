package com.alanjz.spin.daemon;

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

import com.alanjz.spin.daemon.client.DaemonClient;
import com.alanjz.spin.daemon.server.DaemonServer;
import com.alanjz.spin.mpi.request.RequestProtocol;
import com.alanjz.spin.util.service.RequestProtocolService;

import java.io.IOException;

public class DaemonDriver {
  public static void main(String[] args) throws IOException {
    DaemonServer.main(null);
    DaemonClient.main(null);
    try {
      RequestProtocolService.getInstance();
      RequestProtocol r;// = RequestProtocolService.getInstance()
       // .getService("mmap");
      //System.out.println(r.getName() + "/" + r.getVersion());
      Thread.sleep(100000);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
