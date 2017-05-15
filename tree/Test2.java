package tree;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("cdaddadc"));
	}
	
	public static int solution(String s){
		if(delete(s).length()==0){
			return 1;
		}else{
			return 0;
		}
	}
	
	public static String delete(String s){
		if(s.length()%2==1){
			return s;
		}
		int count=0;
		StringBuilder sb = new StringBuilder(s);
		for(int i=0;i<sb.length()-1;i++){
			if(sb.charAt(i) == sb.charAt(i+1)){
				sb.delete(i, i+2);
				i=-1;
				count=0;
			}else{
				count++;
			}
			if(count==2){
				return sb.toString();
			}
		}
		return sb.toString();
	}

}
