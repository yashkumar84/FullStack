function doRegister(){
    const email = document.querySelector('#email').value;
    const password = document.querySelector('#password').value;
    const name = document.querySelector('#name').value;
    const user = {
        email, password , name
    };
    const url = '/register';
    const promise = fetch(url, {method:'post',body: JSON.stringify(user),
        headers: {
    "Content-Type": "application/json",
  }

    }); // ES6 - 2015
    promise.then(response=>{
            response.text().then(data=>{
                console.log('Data From Server is ', data);
                document.querySelector('#output').innerText = data;
            }).catch(err=>{
                console.log('Data Error is ', err);    
            })
        
        
    }).catch(err=>{
        console.log('Error is ', err);
    });

}
