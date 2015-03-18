package klausurUebung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CollectionUebung extends JFrame
{
	Zeichenflaeche zf;
	
	CollectionUebung(){
		super();
		zf=new Zeichenflaeche();
		getContentPane().add(zf,BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setVisible(true);
	}

	private class Zeichenflaeche extends JPanel{
		
		Collection<Point> coll;
		
		Zeichenflaeche() {
			// Fehler bei: coll=new ArrayList<>();
			coll=new ArrayList<Point>();    // gibt alle 6 Punkte aus in ihrer erzeugten Reihenfolge
			//coll=new LinkedList<Point>();
			//coll =new HashSet<Point>();      //gibt nur 5 Punkte aus, jeder Punkt darf nur einmal vorkommen (sortiert (nach Groe�e?))
			fillCollection();
			
		}
		
		void fillCollection(){
			coll.add(new Point(40,40));
			coll.add(new Point(350,40));
			coll.add(new Point(40,350));
			coll.add(new Point(350,350));
			coll.add(new Point(195,10));
			coll.add(new Point(40,40));
			printCollection();
			
		}
		
		void printCollection(){
			System.out.println("Ausgabe per for-Schleife");
			for (Point p:coll){                        //for-each-Schleife
				System.out.println("x: "+ p.x+", y: "+p.y);
			}
			
			Iterator<Point> it=coll.iterator();
			System.out.println( "Ausageb per Iterator");
			while(it.hasNext())
			{
				Point p=it.next();
				System.out.println("x: "+p.x+", y: "+p.y);
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2=(Graphics2D) g;
			setBackground(Color.WHITE);
			
			int[] xCoords= new int[coll.size()];
			int[] yCoords=new int[coll.size()];
			int index=0;
			for (Point p:coll){                        //for-each-Schleife
				xCoords[index]=p.x;
				yCoords[index]=p.y;
				g2.fillOval(p.x-7, p.y-7, 14, 14);
				index++;
			}
			g2.drawPolyline(xCoords, yCoords, xCoords.length);     // oder statt xCoords.length -> 6
		}
		
	}
	
	public static void main(String[] args) {
		new CollectionUebung();

	}

}
