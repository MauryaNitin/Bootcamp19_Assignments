function calculate_si(p, r, t) {
    return (p*r*t)/100;
}

function get_si_input() {
    var p = prompt("Enter Principle Amount (in Rupees)");
    var r = prompt("Enter Rate (in %)");
    var t = prompt("Enter Time (in yrs)");

    if(p !==  "" && r !== "" && t !== ""){
        var result = calculate_si(p,r,t);
        console.log(result);
        alert("The Simple Interest is : " + result);
    }
    else{
        alert("Invalid Values");
    }
}