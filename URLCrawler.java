import java.net.URL;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.nio.charset.*;

public class  URLCrawler
{
	public static void main(String[] args) 
		throws Exception
	{
		ConcurrentLinkedQueue<String> urls = 
			new ConcurrentLinkedQueue<>();
		urls.add( "https://shiroyahisa.github.io/testH5/" );
		int cnt=0;
		while(!urls.isEmpty()){
			String url = urls.poll();
			System.out.println(url);
			new Thread( ()->{
				try{
					String content = download(
						new URL(url),"gb2312");
					List<String> moreUrl = parse( content );
					urls.addAll(moreUrl);
					//System.out.println(moreUrl);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}).start();

			if(cnt++>5) break;
			try{ Thread.sleep(4000);}catch(In
	}
}
