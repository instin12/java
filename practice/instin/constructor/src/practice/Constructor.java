package practice;

public class Constructor {
	int ival;
	char cvalue;
  Constructor(int i){
		ival = i;
		cvalue = 'd';
		
	}
	Constructor(char cval){
		ival = 90;
		cvalue = cval;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Constructor ref = new Constructor('m');
        System.out.println(ref.ival+" "+ref.cvalue);
        Constructor ref1 = new Constructor(40);
        System.out.println(ref1.ival+" "+ref.cvalue);
	}
	}


