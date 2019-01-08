const jwtStrategy   = require('passport-jwt').Strategy;
const jwtExtract    = require('passport-jwt').ExtractJwt;

const User          = require('../models').User;

module.exports = function(passport) {    
    const opts = {
        jwtFromRequest: jwtExtract.fromAuthHeaderWithScheme('JWT'),
        secretOrKey: 'nodeauthsecret',
    };
    passport.use('jwt', new jwtStrategy(opts, function(jwt_payload, done) {
        User
            .findByPk(jwt_payload.id)
            .then((user) => {return done(null, user);})
            .catch((error) => {return done(error, false);});
    }));
};