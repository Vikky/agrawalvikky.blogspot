import java.util.HashMap;
import java.util.TreeMap;

public class HashMapImpl {

	/**
	 * @param args
	 * @author vikky.agrawal
	 */
	
	private String prop;
	
	HashMapImpl(String prop){
		this.prop=prop;		
	}
	
	
	public String getProp() {
		return prop;
	}


	public void setProp(String prop) {
		this.prop = prop;
	}


	
	
	@Override
	public int hashCode(){
		String p=this.getProp();
		char c[]=p.toCharArray();
		int  num=0;
		try{
			for(char a:c){
				int i=(int)a;
				num+=i;
			}			
		}catch(Exception e){
			num=0;			
		}
		return num;
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o instanceof HashMapImpl){
			if(((HashMapImpl) o).getProp().equals(this.getProp())){
				return true;
			}else{
				return false;
			}
		}		
		return false;
	}
	
	
	public static void main(String[] args) {
        HashMap<Integer, String> map=new HashMap<Integer, String>();
        
        map.put(1, "Hello");
        map.put(2, "Hi");
        map.put(3, "Green");
        map.put(1,"Duplicate");       
        
        System.out.println("Last value replaces first : "+map.get(1));
        System.out.println("Will return false : "+map.containsValue("Hello"));       
        
        
        
        TreeMap<String,Integer> treemap=new TreeMap<String, Integer>();
        
        

    }

	
	
}




