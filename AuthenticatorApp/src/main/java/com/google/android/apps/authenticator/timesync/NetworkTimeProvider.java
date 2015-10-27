/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.apps.authenticator.timesync;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Provider of network time that obtains the time by making a network request to Google.
 *
 * @author klyubin@google.com (Alex Klyubin)
 */
public class NetworkTimeProvider {

  private static final String LOG_TAG = NetworkTimeProvider.class.getSimpleName();
  private static final String TIME_URL = "https://www.google.com";

  private HttpURLConnection mhttpURLConnection;

  /**
  public NetworkTimeProvider(HttpURLConnection httpURLConnection) {
    mhttpURLConnection = httpURLConnection;
  }
   **/

  /**
   * Gets the system time by issuing a request over the network.
   *
   * @return time (milliseconds since epoch).
   *
   * @throws IOException if an I/O error occurs.
   */
  public long getNetworkTime() throws IOException {
    URL url = new URL(TIME_URL);
    mhttpURLConnection = (HttpURLConnection)url.openConnection();
    Log.i(LOG_TAG, "Sending request to " + mhttpURLConnection.getURL());
    mhttpURLConnection.connect();

    return mhttpURLConnection.getHeaderFieldDate("Date", new Date().getTime());
  }
}
