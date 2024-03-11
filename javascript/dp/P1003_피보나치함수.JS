const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];
let list = [];
readline.on('line', function(line){
    input.push(line)

}).on("close", function(){
    input.forEach((val) => {
       list.push(val.split(' ').map((el) => parseInt(el)));
    });

    solution(list); // 문제 풀이 함수 호출
    process.exit(); // 프로세스 종료
})

function solution(list) {
    const T = +list.shift()
    for(let i=0; i<T; i++){
        const N = list[i];
        fibo = new Array(N+1);
        fibo[0] = 0;
        fibo[1] = 1;
        for(let j=2; j<=N; j++){
            fibo[j] = fibo[j-1] + fibo[j-2];
        }
        console.log(fibo[N]);
    }
}