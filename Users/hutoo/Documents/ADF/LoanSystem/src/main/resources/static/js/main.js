function log() {
        swal({
            title: "Are you sure you want to log out?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willD) => {
            if (willD) {
                swal({
                    text: "You have been logged out successfully!",
                    icon: "success",
                    buttons: false, // Set buttons to false to remove the OK button
                    timer: 2000, // Automatically close the dialog after 2000 milliseconds (2 seconds)
                });

                    setTimeout(function () { window.location.href = "SignIn"; }, 2000);           // Manually trigger form submission

            }
        });
    }

        function validateForm() {
            // Check if the required fields have been filled
            var loanAmount = document.getElementById("amount").value;
            var loanTerm = document.getElementById("term").value;
            var loanType = document.getElementById("type").value;

            if (loanAmount === "" || loanTerm === "" || loanType === "") {
                swal("Please fill in all required fields before submitting.");
                return false;
            }

            return true;
        }

        $('#btn_submit').on("click", function(e) {
        event.preventDefault();
            if (validateForm()) {

                swal({
                    title: "Are you sure?",
                    text: "Once submitted, you won't be able to modify the request!",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                }).then((willSubmit) => {
                    if (willSubmit) {
                         swal("Your request has been accepted!", {
                                icon: "success",
                             }).then((willSubmit) => {
                                 $('#request-loan-form').submit(); // Manually trigger form submission
                             });

                    } else {
                        swal("Your loan request was not submitted.");
                    }
                });
            }
        });


