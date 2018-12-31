const express   = require('express');
const jwt       = require('jsonwebtoken');
const passport  = require('passport');
const router    = express.Router();
require('../config/passport')(passport);

const Product   = require('../models').Product;
const User      = require('../models').User;



