----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 01/03/2021 06:11:24 PM
-- Design Name: 
-- Module Name: toInteger - Behavioral
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
USE ieee.std_logic_1164.ALL;
USE ieee.numeric_std.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity toInteger is
Port ( Clk, Rst, Start: in STD_LOGIC;
       X: in STD_LOGIC_VECTOR( 31 downto 0); 
       Res: out INTEGER);
end toInteger;

architecture Behavioral of toInteger is
begin
-- -------------------- PROCES TRANSFORMARE REZULTAT --------------------------------------
resultProcess: process (Clk)
begin
    if rising_edge(Clk) then
        if (Rst='1')then
            res<=0;
        else 
            if (Start='1') then
                res<= 1 * to_integer(signed(X(3 downto 0))) + 10*to_integer(signed(X(7 downto 4))) + 100*to_integer(signed(X(11 downto 8))) + 1000*to_integer(signed(X(15 downto 12)))+
                      10000 * to_integer(signed(X(19 downto 16))) + 100000*to_integer(signed(X(23 downto 20))) + 1000000*to_integer(signed(X(27 downto 24))) + 10000000*to_integer(signed(X(31 downto 28)));
            end if;
        end if;
     end if;
end process;
end Behavioral;
