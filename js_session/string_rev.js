function isPalindrome(str) {
    var rev_str = str.split("").reverse().join("");
    return rev_str === str;
}

function get_string(){
    var str = prompt("Enter a string");
    if(str !== ""){
        if(isPalindrome(str.trim().toLowerCase())){
            console.log("The " + str + " is Palindrome.");
            alert("The " + str + " is Palindrome.");
        }
        else{
            console.log("The " + str + " is Not Palindrome.");
            alert("The " + str + " is Not Palindrome.");
        }
    }
    else{
        console.log("Nothing Entered. Please enter a String!");
        alert("Nothing Entered. Please enter a String!")
    }
}
