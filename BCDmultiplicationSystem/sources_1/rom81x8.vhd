----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/30/2020 05:24:26 PM
-- Design Name: 
-- Module Name: rom81x8 - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.std_logic_arith.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity rom81x8 is
Port ( Addr1: in STD_LOGIC_VECTOR(3 downto 0);
       Addr2: in STD_LOGIC_VECTOR(3 downto 0);
       Data: out STD_LOGIC_VECTOR(7 downto 0));
end rom81x8;

architecture Behavioral of rom81x8 is
type mem is array (0 to 81) of STD_LOGIC_VECTOR (7 downto 0);
constant rom : mem := ( "00000000", "00000001", "00000010", "00000011", "00000100", "00000101", "00000110", "00000111", "00001000", "00001001", 
                        "00010000", "00010001", "00010010", "00010011", "00010100", "00010101", "00010110", "00010111", "00011000", "00011001",
                        "00100000", "00100001", "00100010", "00100011", "00100100", "00100101", "00100110", "00100111", "00101000", "00101001",
                        "00110000", "00110001", "00110010", "00110011", "00110100", "00110101", "00110110", "00110111", "00111000", "00111001",
                        "01000000", "01000001", "01000010", "01000011", "01000100", "01000101", "01000110", "01000111", "01001000", "01001001",
                        "01010000", "01010001", "01010010", "01010011", "01010100", "01010101", "01010110", "01010111", "01011000", "01011001",
                        "01100000", "01100001", "01100010", "01100011", "01100100", "01100101", "01100110", "01100111", "01101000", "01101001",
                        "01110000", "01110001", "01110010", "01110011", "01110100", "01110101", "01110110", "01110111", "01111000", "01111001",
                        "10000000", "10000001");
begin
process (Addr1, Addr2)
begin
Data<= rom( CONV_INTEGER(UNSIGNED(Addr1)) * CONV_INTEGER(UNSIGNED(Addr2)));
end process;
end Behavioral;
