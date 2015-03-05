import java.io.*;

public class BibMaker {
	BibMaker(){
		
	}
	BibMaker(String[] values){
		FileWriter fout = null;
		String s;
		try{
			fout =  new FileWriter("/Users/seminkang/documents/reference.txt");
			fout.write("@article{");
			s= values[0];
			fout.write(s+",\n");
			s= values[1];
			fout.write("author = {"+s+"},\n");;
			s= values[2];
			fout.write("title = {{"+s+"}},\n");;
			s=values[3];
			fout.write("year = {"+s+"},\n},\n");;
			
			fout.close();
		}catch(IOException e){
			System.out.println("io error");
		}
			
	}
	public void makeDBtoFile(String values[]){
		FileWriter fout = null;
		try{
			fout =  new FileWriter("/Users/seminkang/documents/bib.txt");
			int i =0;
			
			while(values[i]!=null){
				fout.write("@article{");
				fout.write(values[i]+",\n");
				fout.write("author = {"+values[i+1]+"},\n");;
				fout.write("title = {{"+values[i+2]+"}},\n");;
				fout.write("year = {"+values[i+3]+"},\n},\n\n");;
				i+=4;
			}
			
			
			fout.close();
		}catch(IOException e){
			System.out.println("io error");
		}
	}
}
