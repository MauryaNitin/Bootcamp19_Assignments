var emp = [
    {
        name: 'Phil',
        age: 22,
        salary: 900,
        dob: '27/05/1997'
    },
    {
        name: 'Tony',
        age: 26,
        salary: 300,
        dob: '12/06/1991'
    },
    {
        name: 'Jon',
        age: 39,
        salary: 7000,
        dob: '29/01/1995'
    },
    {
        name: 'Smith',
        age: 26,
        salary: 1000,
        dob: '08/03/1999'
    },
    {
        name: 'Angel',
        age: 39,
        salary: 9000,
        dob: '10/11/2000'
    },

];

function filter_emp(){
    var temp = [];
    for(let i = 0; i < emp.length; i++) {
        if(emp[i].salary > 5000){
            temp.push(emp[i]);
        }
    }
    console.log("Employees filtered whose salary > 5000: " + JSON.stringify(temp, null, 4));
    document.getElementById('fil').innerHTML = JSON.stringify(temp);
}

function group_by_age(){
    var list = {};
    for(var i = 0; i < emp.length; i++){
        if(!list[emp[i].age]){
            list[emp[i].age] = [emp[i]];
        }
        else{
            list[emp[i].age].push(emp[i]);
        }
    }
    console.log("Employees grouped by age: " + JSON.stringify(list,null,4));
    document.getElementById('age').innerHTML = JSON.stringify(list);
}


function increment(){
    let temp = [];
    for(let i = 0; i < emp.length; i++){
        temp.push(emp[i]);
        if(emp[i].salary < 1000 && emp[i].age > 20){
            temp[i].salary = 5 * temp[i].salary;
        }
    }
    console.log("Employees after increment: " + JSON.stringify(temp, null, 4));
    document.getElementById('inc').innerHTML = JSON.stringify(temp);
}


document.getElementById('emp-info').innerHTML = JSON.stringify(emp);
