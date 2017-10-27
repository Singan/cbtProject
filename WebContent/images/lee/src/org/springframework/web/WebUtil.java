package org.springframework.web;

import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class WebUtil {
	//clz로 들어온 클래스 정보를 읽고 requests의 파라미터에서 정보를 추출한다.
	//파라미터 정보가 설정된 객체를 반환
	public static Object toVO(Object request, Class<?> clz) throws Exception{
		
		//메서드를 실행하기 위한 객체 생성
		Object obj = clz.newInstance();
		
		//clz 클래스 객체의 모든 메서드를 추출
		Method[] mArr = clz.getDeclaredMethods();
		for(Method m : mArr) {
			//메서드 이름 확인하기
			//get , set
			String mName = m.getName();
			
			if(mName.startsWith("set")) {
				String param = mName.substring("set".length());
				
				param = Character.toLowerCase(param.charAt(0))+param.substring(1);
				String reqName = request.getClass().getSimpleName();
				String pValue = null;
				
				switch(reqName) {
				case "MultipartRequest" :
					pValue = ((MultipartRequest)request).getParameter(param);
					break;
				default :
					pValue = ((HttpServletRequest)request).getParameter(param);
					break;
				}
				//이름에 해당하는 파라미터의 값이 없을 경우
				if(pValue != null ) {
					//메서드와 해당하는 파라미터값이 존재하는 경우 메서드의 매개변수 타입이 정수인 경우
					//문자열을 정수로 변경한 다음 값을 대입
					
					switch(m.getParameterTypes()[0].getName()) {
						case "int" :
							m.invoke(obj, Integer.parseInt(pValue));
							break;
						default :
							m.invoke(obj, pValue);
							break;
					}
				}
			}
			
		}
		
		return obj;
	}
}
