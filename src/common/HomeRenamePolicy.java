package common;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class HomeRenamePolicy implements FileRenamePolicy{
	
	@Override
	public File rename(File f) {
		// TODO Auto-generated method stub
		String name = f.getName();
		String ext = ""; // 확장자를 저장하기 위한 변수
		int index = name.lastIndexOf(".");
		if(index != -1) {
			ext = name.substring(index);
		}
		
		String parent = f.getParent();
		
		String fName = UUID.randomUUID().toString();
		
		return new File(parent, fName + ext);
	}
	
	
}
