var obj = {
    first_name: 'nitin',
    last_name: 'maurya',
    phn: 8130137906,
    org: 'to the new'
};

function cpy_obj(obj){
    var new_obj = {};
    for(var x in obj){
        new_obj[x] = obj[x];
    }
    document.getElementById('obj_equality').innerHTML = (obj === new_obj);
    document.getElementById('show-obj-cpy').innerHTML = JSON.stringify(new_obj);
    console.log(obj);
    console.log(new_obj);
    console.log("obj === new_obj : " + (obj === new_obj).toString());
}

document.getElementById('show-obj-orig').innerHTML = JSON.stringify(obj);

function start_cpy() {
    cpy_obj(obj);
}
