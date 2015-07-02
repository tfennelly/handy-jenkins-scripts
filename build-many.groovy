// HOWTO:
//     1. Update the 'jobName' and 'numBuilds' appropriately.
//     2. Copy and run the script in the Jenkins Script Console (Manage Jenkins -> Script Console).

def jobName = 'freebie';
def numBuilds = 100;

def job = Jenkins.instance.getItem(jobName);

for (int i = 0; i < numBuilds; i++) {
  def future = job.scheduleBuild2(0);
  def build = future.waitForStart();
  while (build.isBuilding()) {
    Thread.sleep(100);
  }
}
println('finished');
