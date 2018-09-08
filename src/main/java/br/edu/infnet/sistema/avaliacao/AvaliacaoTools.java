/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author leonam
 */
public class AvaliacaoTools {

    public static java.sql.Timestamp getCurrentTime() {
        return Timestamp.from(LocalDateTime.now()
                .atZone(ZoneId.of("GMT-3")).toInstant());

    }

}
