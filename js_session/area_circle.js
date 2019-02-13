function cal_area(r){
    return 3.14 * r * r;
}

function area() {
    var radius = document.getElementById("circle").value;
    if(radius !== "" && !isNaN(radius)){
        document.getElementById('ques3-result').innerHTML = cal_area(parseInt(radius, 10));
        console.log("The area of circle is: " + cal_area(parseInt(radius, 10)));
    }
    else{
        alert("Invalid value of radius!");
        console.log("Invalid value of radius!");
        document.getElementById('circle').value = '';
    }
}
