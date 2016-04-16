/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function changeImage(trailNumber) {
  var x = document.getElementById("myDuration");
  if (trailNumber === 1)
  {
    document.images.trail.src="TrailGardiner.jpg";
    x.remove(0);
    x.remove(0);
    x.remove(0);
    var dur1=document.createElement("option");
    var dur2=document.createElement("option");
    dur1.text="3";
    dur2.text="5";
    dur1.value="3";
    dur2.value="5";
    x.add(dur1);
    x.add(dur2);
  }
  if (trailNumber === 2)
  {
    x.remove(0);
    x.remove(0);
    x.remove(0);
    document.images.trail.src="hellroaringTrail.jpg";
    var dur1=document.createElement("option");
    var dur2=document.createElement("option");
    var dur3=document.createElement("option");
    dur1.text="2";
    dur2.text="3";
    dur3.text="4";
    dur1.value="2";
    dur2.value="3";
    dur3.value="4";
    x.add(dur1);
    x.add(dur2);
    x.add(dur3);
  }
  if (trailNumber === 3)
  {
    document.images.trail.src="beautiful-stone-creek-in-the-forest.jpg";
    x.remove(0);
    x.remove(0);
    x.remove(0);
    var dur1=document.createElement("option");
    var dur2=document.createElement("option");
    dur1.text="5";
    dur2.text="7";
    dur1.value="5";
    dur2.value="7";
    x.add(dur1);
    x.add(dur2);
  }
}
