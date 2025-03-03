<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
    <style>

        @import url(https://fonts.googleapis.com/css?family=Roboto:100,300,400,900,700,500,300,100);

        * {
            margin: 0;
            box-sizing: border-box;

        }

        body {
            background: #E0E0E0;
            font-family: 'Roboto', sans-serif;
            background-image: url('');
            background-repeat: repeat-y;
            background-size: 100%;
        }

        ::selection {
            background: #f31144;
            color: #FFF;
        }

        ::moz-selection {
            background: #f31544;
            color: #FFF;
        }

        h1 {
            font-size: 1.5em;
            color: #222;
        }

        h2 {
            font-size: .9em;
        }

        h3 {
            font-size: 1.2em;
            font-weight: 300;
            line-height: 2em;
        }

        p {
            font-size: .7em;
            color: #666;
            line-height: 1.2em;
        }

        #invoiceholder {
            width: 100%;
            hieght: 100%;
            padding-top: 50px;
        }

        #headerimage {
            z-index: -1;
            position: relative;
            top: -50px;
            height: 350px;
            background-image: url('http://michaeltruong.ca/images/invoicebg.jpg');

            -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, .15), inset 0 -2px 4px rgba(0, 0, 0, .15);
            -moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, .15), inset 0 -2px 4px rgba(0, 0, 0, .15);
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, .15), inset 0 -2px 4px rgba(0, 0, 0, .15);
            overflow: hidden;
            background-attachment: fixed;
            background-size: 1920px 80%;
            background-position: 50% -90%;
        }

        #invoice {
            position: relative;
            top: -290px;
            margin: 0 auto;
            width: 700px;
            background: #FFF;
        }

        [id*='invoice-'] { /* Targets all id with 'col-' */
            border-bottom: 1px solid #EEE;
            padding: 30px;
        }

        #invoice-top {
            min-height: 120px;
        }

        #invoice-mid {
            min-height: 120px;
        }

        #invoice-bot {
            min-height: 250px;
        }

        .logo {
            float: left;
            height: 60px;
            width: 60px;
            background: url(https://static.vecteezy.com/system/resources/previews/011/144/540/non_2x/jewelry-ring-abstract-logo-template-design-with-luxury-diamonds-or-gems-isolated-on-black-and-white-background-logo-can-be-for-jewelry-brands-and-signs-free-vector.jpg) no-repeat;
            background-size: 60px 60px;
        }

        .clientlogo {
            float: left;
            height: 60px;
            width: 60px;
            background: url(http://michaeltruong.ca/images/client.jpg) no-repeat;
            background-size: 60px 60px;
            border-radius: 50px;
        }

        .info {
            display: block;
            float: left;
            margin-left: 20px;
        }

        .title {
            float: right;
        }

        .title p {
            text-align: right;
        }

        #project {
            margin-left: 52%;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 5px 0 5px 15px;
            border: 1px solid #EEE
        }

        .tabletitle {
            padding: 5px;
            background: #EEE;
        }

        .service {
            border: 1px solid #EEE;
        }

        .item {
            width: 50%;
        }

        .itemtext {
            font-size: .9em;
        }

        #legalcopy {
            margin-top: 30px;
        }

        form {
            float: right;
            margin-top: 30px;
            text-align: right;
        }


        .effect2 {
            position: relative;
        }

        .effect2:before, .effect2:after {
            z-index: -1;
            position: absolute;
            content: "";
            bottom: 15px;
            left: 10px;
            width: 50%;
            top: 80%;
            max-width: 300px;
            background: #777;
            -webkit-box-shadow: 0 15px 10px #777;
            -moz-box-shadow: 0 15px 10px #777;
            box-shadow: 0 15px 10px #777;
            -webkit-transform: rotate(-3deg);
            -moz-transform: rotate(-3deg);
            -o-transform: rotate(-3deg);
            -ms-transform: rotate(-3deg);
            transform: rotate(-3deg);
        }

        .effect2:after {
            -webkit-transform: rotate(3deg);
            -moz-transform: rotate(3deg);
            -o-transform: rotate(3deg);
            -ms-transform: rotate(3deg);
            transform: rotate(3deg);
            right: 10px;
            left: auto;
        }

        .legal {
            width: 70%;
        }
    </style>
</head>
<div id="invoiceholder">
    <div id="headerimage"></div>
    <div id="invoice" class="effect2">

        <div id="invoice-top">
            <div class="logo"></div>
            <div class="info">
                <h2>Michael Truong</h2>
                <p> hello@michaeltruong.ca </br>
                    289-335-6503
                </p>
            </div><!--End Info-->
            <div class="title">
                <h1>Invoice #1069</h1>
                <p>Issued: May 27, 2015</br>
                    Payment Due: June 27, 2015
                </p>
            </div><!--End Title-->
        </div><!--End InvoiceTop-->


        <div id="invoice-mid">

            <div class="clientlogo"></div>
            <div class="info">
                <h2>Client Name</h2>
                <p>JohnDoe@gmail.com</br>
                    555-555-5555</br>
            </div>

            <div id="project">
                <h2>Project Description</h2>
                <p>Proin cursus, dui non tincidunt elementum, tortor ex feugiat enim, at elementum enim quam vel purus.
                    Curabitur semper malesuada urna ut suscipit.</p>
            </div>

        </div><!--End Invoice Mid-->

        <div id="invoice-bot">

            <div id="table">
                <table>
                    <tr class="tabletitle">
                        <td class="item"><h2>Item Description</h2></td>
                        <td class="Hours"><h2>Hours</h2></td>
                        <td class="Rate"><h2>Rate</h2></td>
                        <td class="subtotal"><h2>Sub-total</h2></td>
                    </tr>
                    <#list cart as e>
                        <tr class="service">
                            <td class="tableitem"><p class="itemtext">Communication</p></td>
                            <td class="tableitem"><p class="itemtext">5</p></td>
                            <td class="tableitem"><p class="itemtext">$75</p></td>
                            <td class="tableitem"><p class="itemtext">$375.00</p></td>
                        </tr>
                    </#list>

                    <tr class="tabletitle">
                        <td></td>
                        <td></td>
                        <td class="Rate"><h2>Total</h2></td>
                        <td class="payment"><h2>$3,644.25</h2></td>
                    </tr>

                </table>
            </div><!--End Table-->

            <form action="" method="post" target="_top">
                <input type="hidden" name="cmd" value="_s-xclick">
                <input type="hidden" name="hosted_button_id" value="QRZ7QTM9XRPJ6">
                <input type="image" src="https://cdn.haitrieu.com/wp-content/uploads/2022/10/Logo-VNPAY-QR.png" border="0" name="submit"
                       alt="PayPal - The safer, easier way to pay online!">
            </form>


            <div id="legalcopy">
                <p class="legal"><strong>Thank you for your business!</strong>  Payment is expected within 31 days;
                    please process this invoice within that time. There will be a 5% interest charge per month on late
                    invoices.
                </p>
            </div>

        </div><!--End InvoiceBot-->
    </div><!--End Invoice-->
</div><!-- End Invoice Holder-->
</html>