<?php

$sql = "select * from";   // NOK

$sql = "sElect * from";   // NOK

$sql = "select a from b";   // OK

$sql = "select "; // OK

$sql .= " * from"; // OK