/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hudson.plugins.projectstats;

import hudson.model.Job;

/**
 *
 * @author Marco Ambu
 */
public interface Stats {

  public void compute(Job job);

}
