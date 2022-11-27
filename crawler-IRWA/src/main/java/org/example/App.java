package org.example;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.io.File;
import java.io.FileWriter;


public class App {

	public static void main(String[] args) throws Exception {
		
		File crawlStorage = new File("D:\\MSC_UOM\\IRWA\\Crawled_Data");
		
		 CrawlConfig config = new CrawlConfig();
	     config.setCrawlStorageFolder(crawlStorage.getAbsolutePath());
		// TODO Auto-generated method stub
	     
	     int numCrawlers = 12;

	     PageFetcher pageFetcher = new PageFetcher(config);
	     
	     
	     RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
	     RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
	     CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

	     controller.addSeed("https://www.bbc.com/sport/football");
	     
	     CrawlerStatistics stats = new CrawlerStatistics();
	     String file_path = "D:\\\\MSC_UOM\\\\IRWA\\\\Crawled_Data\\bbc_sports.xml";
	     
	     File myObj = new File(file_path);
	     if (myObj.createNewFile()) {
	            System.out.println("File created: " + myObj.getName());
	     } else {
	            System.out.println("File already exists.");
	     }
	     
	     FileWriter myWriter = new FileWriter(file_path);
	     CrawlController.WebCrawlerFactory<HTMLCrawler> factory = () -> new HTMLCrawler(stats, myWriter);
	     
	     try {
	            controller.start(factory, numCrawlers);
	        } finally {
	            myWriter.close();
	            System.out.println("Done writing to the file.");
	        }



	}

}
