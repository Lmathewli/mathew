var fun1 = function(name) {
    print('Hi there from Javascript, ' + name);
    return "greetings from javascript";
};

var fun2 = function () {
    var person = new Person('mathew', 'li');
    var MyJavaClass = Java.type('mathew.Js');
    MyJavaClass.fun4(person);
};

function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.getFullName = function() {
        return this.firstName + " " + this.lastName;
    }
}

function testThread() {
    var Runnable = Java.type("java.lang.Runnable");
    var Printer = Java.extend(Runnable, {run: function(){
        print('printed from a separate thread');
    }});
    var Thread = Java.type('java.lang.Thread');
    new Thread(new Printer()).start();

    new Thread(function() {
        print('printed from another thread');
    }).start();
}
