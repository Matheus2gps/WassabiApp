/**
 * 
 */
package com.treinamentonetbiis.wassabi;

/**
 * @author Matheus Gonçalves
 * 
 * Este arquivo implementa Vendas
 * Implementado em 07-11-2022
 */
public record Vendas(int idVenda,int idCliente, String cliente,int idProduto,String produto,int quantidade,double valor_produto,double valor_total) {

}
