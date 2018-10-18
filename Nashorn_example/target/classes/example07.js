var t = java.lang.System.currentTimeMillis();

var MyThread = Java.extend(Java.type("java.lang.Thread"));

var thread = new MyThread({
    run: function(){
        print("ejecutando thread");
        for (var i=0; i<10;i++){
            print("paso " + i);
        }
    }
});

thread.start();
print("hilo lanzado");
thread.join();

tFinal = java.lang.System.currentTimeMillis();

print("tiempo: " + (tFinal-t)/1000 + " s");