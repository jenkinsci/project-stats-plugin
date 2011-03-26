/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hudson.plugins.projectstats;

import hudson.model.Job;
import hudson.model.Result;
import hudson.model.Run;
import java.util.List;

/**
 *
 * @author Marco Ambu
 */
public class NumBuildsStatsBuilder {

  private NumBuildsStats stats;

  public NumBuildsStatsBuilder(Job job) {
    this.stats = new NumBuildsStats();
    List<Run> builds = job.getBuilds();
    for (Run build : builds) {
      if (build.getResult().isBetterOrEqualTo(Result.SUCCESS))
        this.stats.addSuccess();
      else if (build.getResult().isBetterOrEqualTo(Result.UNSTABLE))
        this.stats.addUnstable();
      else if (build.getResult().isBetterOrEqualTo(Result.FAILURE))
        this.stats.addFail();
    }
  }

  public NumBuildsStats getNumBuildStats() {
    return stats;
  }

}
