----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/30/2020 12:57:23 PM
-- Design Name: 
-- Module Name: sumatorSemiZecimal - Behavioral
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
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity sumatorSemiZecimal is
Generic (n: natural:=4);
Port ( X: in STD_LOGIC_VECTOR(2*n-1 downto 0);
       Y: in STD_LOGIC_VECTOR(n-1 downto 0);
       S: out STD_LOGIC_VECTOR(2*n-1 downto 0);
       Tin: in STD_LOGIC;
       Tout: out STD_LOGIC);
end sumatorSemiZecimal;

architecture Behavioral of sumatorSemiZecimal is
signal auxTout: STD_LOGIC;
signal auxData:STD_LOGIC_VECTOR(n-1 downto 0):=(others =>'0');
begin
suma0: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(3 downto 0), Y=>Y, S=>S(3 downto 0), Tin=>Tin, Tout=>auxTout);
suma1: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(7 downto 4), Y=>"0000", S=>S(7 downto 4), Tin=>auxTout, Tout=>Tout);
end Behavioral;
