package lambdasinaction._02stream.without.optional;

import java.util.Optional;

public class MobileService {
	
	public int getMobileScreenWidth(Mobile mobile){
		if(mobile != null){
			DisplayFeatures dfeatures = mobile.getDisplayFeatures();
			if(dfeatures != null){
				ScreenResolution resolution = dfeatures.getResolution();
				if(resolution != null){
					return resolution.getWidth();
				}
			}
		}
		return 0;
	}
	
}
