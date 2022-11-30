const b = document.getElementById("crearCuenta")
const vUsuario = document.getElementById("usuario");
const vContrasenia = document.getElementById("contraseña");
const vRecontrasenia = document.getElementById("recontraseña");
const vEmail = document.getElementById("email");

b.addEventListener("click", () => {
    let usuario_ = vUsuario.value;
    let contrasenia_ = vContrasenia.value;
    let recontrasenia_ = vRecontrasenia.value;
    let email_ = vEmail.value;

    

    if(validarDatos(usuario_, contrasenia_, recontrasenia_, email_)){
        axios.post("http://localhost:80/crearCuenta", {
            usuario: usuario_,
            contrasenia: contrasenia_,
            email: email_
        })
        .then(function (res) {
            window.open("creacionExitosa.html", '_self')
        })
        .catch(function (error) {
            
        })
    }
})

function validarDatos(usuario, contrasenia, recontrasenia, email) {
    valido = true;

        if(usuario.textLength == 0) {
            vUsuario.style.borderColor = "Red";
            valido = false
        }

        if(contrasenia.textLength == 0) {
            vContrasenia.style.borderColor = "Red";
            valido = false
        }

        if(recontrasenia.textContent == 0) {
            vRecontrasenia.style.borderColor = "Red";
            valido = false
        }

        if(email.textContent == 0) {
            vEmail.style.borderColor = "Red";
            valido = false
        }

        if(contrasenia != recontrasenia) {
            vContrasenia.style.borderColor = "Red";
            vRecontrasenia.style.borderColor = "Red";
            valido = false;
        }

    return valido;
}