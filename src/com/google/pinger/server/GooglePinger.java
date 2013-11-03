/*
# Copyright 2012 Ruben Afonso, http://www.figurebelow.com
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
 */

package com.google.pinger.server;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The main class that invokes the GET method.
 */
public class GooglePinger extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GooglePinger.class
			.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// A list of URLS if we want to ping more than one.
		List<URL> urlList = new ArrayList<URL>();
		// An example URL, change this with your preferred URL
		urlList.add(new URL("http://www.google.es"));
		for (URL url : urlList) {
			try {
				// The GET request is generated here when openStream() is
				// executed.
				url.openStream();
				log.info("Ping: " + url + " ... done");
			} catch (IOException e) {
				/**
				 * This message is printed when the openStream() method fails. This could
				 * mean that the remote server answered with a 404/50x code for
				 * example, so the GET request may have been sent anyway.
				 */
				log.info("Error ping: " + url
						+ "(GET request may be succeeded though)");
			}
		}
	}
}
