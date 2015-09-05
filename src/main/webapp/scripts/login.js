function initValidation()
    {
        var objForm = document.forms["loginForm"];
         objForm.j_username.required = 1;
        // objForm.j_username.regexp = /^\w*$/;
  
        objForm.j_password.required = 1;
        objForm.j_password.minlength = 3;
        objForm.j_password.maxlength = 64;
    }