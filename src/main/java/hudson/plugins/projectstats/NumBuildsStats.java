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

package hudson.plugins.projectstats;

import hudson.model.Job;
import hudson.model.Result;
import hudson.model.Run;
import java.util.List;

/**
 *
 * @author Marco Ambu
 */
public class NumBuildsStats implements Stats {

  int success;
  int unstable;
  int fail;

  public NumBuildsStats() {
    this.success = 0;
    this.unstable = 0;
    this.fail = 0;
  }

  public void compute(Job job) {
    List<Run> builds = job.getBuilds();
    for (Run build : builds) {
      if (build.getResult().isBetterOrEqualTo(Result.SUCCESS))
        addSuccess();
      else if (build.getResult().isBetterOrEqualTo(Result.UNSTABLE))
        addUnstable();
      else if (build.getResult().isBetterOrEqualTo(Result.FAILURE))
        addFail();
    }
  }

  public void addSuccess() {
    success++;
  }

  public void addUnstable() {
    unstable++;
  }

  public void addFail() {
    fail++;
  }

  public int getSuccess() {
    return success;
  }

  public int getUnstable() {
    return unstable;
  }

  public int getFail() {
    return fail;
  }

}
