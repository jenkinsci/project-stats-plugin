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

package hudson.plugins.projectstats.column;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.Job;
import hudson.plugins.projectstats.NumBuildsStats;
import hudson.views.ListViewColumn;
import java.util.ResourceBundle;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

/**
 * View column that shows the job type.
 * @author Alan.Harder@sun.com
 */
public class NumBuildsColumn extends ListViewColumn {

    @Extension
    public static final Descriptor<ListViewColumn> DESCRIPTOR = new DescriptorImpl();

    @Override
    public Descriptor<ListViewColumn> getDescriptor() {
        return DESCRIPTOR;
    }
  private static final ResourceBundle numbuildscolumn = ResourceBundle.getBundle("hudson/plugins/projectstats/column/NumBuildsColumn/numbuildscolumn");

    public NumBuildsStats getStats(Job job) {
        NumBuildsStats stats = new NumBuildsStats();
        stats.compute(job);
        return stats;
    }

    private static class DescriptorImpl extends Descriptor<ListViewColumn> {
        @Override
        public ListViewColumn newInstance(StaplerRequest req, JSONObject formData) throws FormException {
            return new NumBuildsColumn();
        }

        @Override
        public String getDisplayName() {
            return numbuildscolumn.getString("NumBuildsColumn");
        }
    }
}
