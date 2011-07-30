/*
 * The MIT License
 *
 * Copyright (c) 2011, Marco Ambu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hudson.plugins.projectstats.portlet;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.Job;
import hudson.plugins.projectstats.NumBuildsStats;
import hudson.plugins.view.dashboard.DashboardPortlet;
import java.util.ResourceBundle;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 *
 * @author Marco Ambu
 */
public class NumBuildsPortlet extends DashboardPortlet {
  private static final ResourceBundle numbuildsportlet = ResourceBundle.getBundle("hudson/plugins/projectstats/portlet/NumBuildsPortlet/numbuildsportlet");

	@DataBoundConstructor
	public NumBuildsPortlet(String name) {
		super(name);
	}

  public NumBuildsStats getStats(Job job) {
    NumBuildsStats stats = new NumBuildsStats();
    stats.compute(job);
    return stats;
  }

  @Extension
  public static class DescriptorImpl extends Descriptor<DashboardPortlet> {

		@Override
		public String getDisplayName() {
			return numbuildsportlet.getString("NumBuilsPortlet");
		}
	}

}
