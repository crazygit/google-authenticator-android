/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wiseturtles.crazygit.google.authenticator.settings;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.wiseturtles.crazygit.google.authenticator.testability.TestablePreferenceActivity;
import com.wiseturtles.crazygit.google.authenticator.util.annotations.FixWhenMinSdkVersion;
import com.wiseturtles.crazygit.google.authenticator.R;

/** Activity that displays the "About" preferences. */
public class SettingsAboutActivity extends TestablePreferenceActivity {

  @FixWhenMinSdkVersion(11) @SuppressWarnings("deprecation")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    addPreferencesFromResource(R.xml.preferences_about);

    try {
      String packageVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
      findPreference("version").setSummary(packageVersion);
    } catch (NameNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
