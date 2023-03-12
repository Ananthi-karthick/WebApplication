<template>
<div class="container py-5">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" referrerpolicy="no-referrer" />
  <div class="col-sm-4">
        <div class="rounded bg-gradient-4 text-DARK shadow p-2 text-center mb-2">
            <div id="clock-c" class="countdown py-4"></div>
        </div>
    </div>
</div>
</template>
<script>
// <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js"></script>
// <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
// <script src="https://cdnjs.cloudflare.com/ajax/libs/video.js/8.0.4/video.min.js" integrity="sha512-B4KryhFGXd4MaD6N0DU63hmqgxlgggt6uIVorY5k7HBl6DUP/RP1sLxttHAHIV5sWErhdiXZZpumE+5EPD0qPg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
// <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.countdown/2.2.0/jquery.countdown.min.js" integrity="sha512-lteuRD+aUENrZPTXWFRPTBcDDxIGWe5uu0apPEn+3ZKYDwDaEErIK9rvR0QzUGmUQ55KFE2RqGTVoZsKctGMVw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
export default{
        name:'Timer',
    }

    $(function () {
        function get15dayFromNow() {
            return new Date(new Date().valueOf() + 30 * 1000);
        }
    
        $('#clock-c').countdown(get15dayFromNow(), function(event) {
          var $this = $(this).html(event.strftime(''
            + '<span class="h1 font-weight-bold">%S</span> Sec'));
        });
    });
    
</script>
<style>
    .bg-gradient-4 {
        background: -webkit-linear-gradient(to right, #95fffb, #08e3e3);
        background: linear-gradient(to right, #ffffff, #007fb5);
    }
    
    .rounded {
        border-radius: 1rem !important;
    }
</style>



         