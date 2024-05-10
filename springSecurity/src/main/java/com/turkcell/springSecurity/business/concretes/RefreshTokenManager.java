package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.RefreshTokenService;
import com.turkcell.springSecurity.core.utilities.exceptions.types.BusinessException;
import com.turkcell.springSecurity.dataAccess.abstracts.RefreshTokenRepository;
import com.turkcell.springSecurity.entities.concretes.RefreshToken;
import com.turkcell.springSecurity.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RefreshTokenManager implements RefreshTokenService {
    private RefreshTokenRepository refreshTokenRepository;
    @Override
    public RefreshToken create(User user) {
        RefreshToken token=new RefreshToken();
        token.setUser(user);
        token.setToken("abc");//TODO:Refactor(use jwtService.generateToken()with longer expriration time)
        token.setExpirationDate(LocalDateTime.now().plusDays(10));
        refreshTokenRepository.save(token);
        return token;
    }

    @Override
    public RefreshToken verifyRefreshToken(String token) {
        RefreshToken refreshToken=refreshTokenRepository
                .findByToken(token)
                .orElseThrow(()->new BusinessException("Refresh token not found"));

        //Tüm şartlar sağlanırsa
        if(refreshToken.getExpirationDate().isBefore(LocalDateTime.now()))
            throw new BusinessException("Refresh token expired.Please login again.");
        if(refreshToken.getRevokedDate()!=null)
            throw new BusinessException("Refresh token revoked.");
        return refreshToken;
    }
    private void revokeAllTokens(User user){
       // TODO:revoke
    }
}
