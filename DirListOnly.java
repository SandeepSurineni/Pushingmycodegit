import java.io.File;
import java.io.FilenameFilter;

public class DirListOnly {
	  public static void main(String args[]) {
		  
		  
		    String dirname = "/var/lib/jenkins/work_dir/Pushingmycodegit";
		    File f1 = new File(dirname);
		    
                    FilenameFilter only = new OnlyExt("zip");
		    FilenameFilter only1 = new OnlyExt("tar");

		    String s[] = f1.list(only);
                    String s1[] = f1.list(only1);
		    for (int i = 0; i < s.length; i++) {
		      System.out.println(s[i]);
		    }
                      for (int k = 0; k < s1.length; k++) {
			 System.out.println(s1[k]);
			    }
		  }
		}

		class OnlyExt implements FilenameFilter {
		  String ext;

		  public OnlyExt(String ext) {
		    this.ext = "." + ext;
		  }

		  public boolean accept(File dir, String name) {
		    return name.endsWith(ext);
		  }

}
 
