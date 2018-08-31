//
//  GameScene.swift
//  NoughtsAndCrossesGame
//
//  Created by Javax on 25/08/2018.
//  Copyright © 2018 Javax Inc. All rights reserved.
//

import SpriteKit
import GameplayKit

class GameScene: SKScene {
	
	var box0:SKSpriteNode!
	var box1:SKSpriteNode!
	var box2:SKSpriteNode!
	var box3:SKSpriteNode!
	var box4:SKSpriteNode!
	var box5:SKSpriteNode!
	var box6:SKSpriteNode!
	var box7:SKSpriteNode!
	var box8:SKSpriteNode!
	
	override func didMove(to view: SKView) {
		box0 = childNode(withName: "box0") as! SKSpriteNode
		box1 = childNode(withName: "box1") as! SKSpriteNode
		box2 = childNode(withName: "box2") as! SKSpriteNode
		box3 = childNode(withName: "box3") as! SKSpriteNode
		box4 = childNode(withName: "box4") as! SKSpriteNode
		box5 = childNode(withName: "box5") as! SKSpriteNode
		box6 = childNode(withName: "box6") as! SKSpriteNode
		box7 = childNode(withName: "box7") as! SKSpriteNode
		box8 = childNode(withName: "box8") as! SKSpriteNode
		
		var i = 0;
		while (i < 9) {
			setText(of: i, to: "")
			i += 1
		}
	}
	
	override func mouseUp(with event: NSEvent) {
		let touchedNodes = nodes(at: event.location(in: self))
		
		if (touchedNodes.count == 0) {
			return
		}
		
		if (touchedNodes[0] == box0) {
			boxTapped(box: 0);
		} else if (touchedNodes[0] == box1) {
			boxTapped(box: 1);
		} else if (touchedNodes[0] == box2) {
			boxTapped(box: 2);
		} else if (touchedNodes[0] == box3) {
			boxTapped(box: 3);
		} else if (touchedNodes[0] == box4) {
			boxTapped(box: 4);
		} else if (touchedNodes[0] == box5) {
			boxTapped(box: 5);
		} else if (touchedNodes[0] == box6) {
			boxTapped(box: 6);
		} else if (touchedNodes[0] == box7) {
			boxTapped(box: 7);
		} else if (touchedNodes[0] == box8) {
			boxTapped(box: 8);
		}
		
		makeMove()
	}
	
	func makeMove () {
		// Currently will simply choose a random square
		
		var available:[Int] = []
		var i = 0;
		
		while (i < 9) {
			if (boxes[i] == "") {
				available.append(i)
			}
			i += 1
		}
		if (available.count > 0) {
			var rand:Int = Int(arc4random_uniform(UInt32(available.count - 1)))
		
			boxes[available[rand]] = "x"
			setText(of: available[rand], to: "x")
		} else {
			exit (0)
		}
	}
	
	var boxes:[String] = ["", "", "", "", "", "", "", "", ""]
	
	func boxTapped (box:Int) {
		if (boxes[box] == "o") {
			return
		}
		if (boxes[box] == "x") {
			return
		}
		
		boxes[box] = "o"
		setText (of: box, to: "o")
	}
	
	func setText (of box:Int, to text:String) {
		switch box {
		case 0:
			(box0.children[0] as! SKLabelNode).text = text
			break
		case 1:
			(box1.children[0] as! SKLabelNode).text = text
			break
		case 2:
			(box2.children[0] as! SKLabelNode).text = text
			break
		case 3:
			(box3.children[0] as! SKLabelNode).text = text
			break
		case 4:
			(box4.children[0] as! SKLabelNode).text = text
			break
		case 5:
			(box5.children[0] as! SKLabelNode).text = text
			break
		case 6:
			(box6.children[0] as! SKLabelNode).text = text
			break
		case 7:
			(box7.children[0] as! SKLabelNode).text = text
			break
		case 8:
			(box8.children[0] as! SKLabelNode).text = text
			break
		default:
			break
		}
	}
    
    override func update(_ currentTime: TimeInterval) {
        // Called before each frame is rendered
    }
}
