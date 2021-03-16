----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 01/06/2021 11:18:22 AM
-- Design Name: 
-- Module Name: testBenchModulPrincipal - Behavioral
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
use IEEE.STD_LOGIC_SIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity testBenchModulPrincipal is
--  Port ( );
end testBenchModulPrincipal;

architecture Behavioral of testBenchModulPrincipal is
signal Clk, Rst, Start,Save: STD_LOGIC:='0';
signal Sel: STD_LOGIC_VECTOR(1 downto 0);
signal S: STD_LOGIC_VECTOR(15 downto 0):= (others => '0');
signal An, Seg: STD_LOGIC_VECTOR(7 downto 0):= (others => '0');
signal Stop: STD_LOGIC;
constant clockPeriod : time := 20 ns;
begin

clk_process: process
begin
    Clk <= '0';
    wait for clockPeriod/2;
    Clk <= '1';
    wait for clockPeriod/2;
end process;

DUT: entity WORK.modulPrincipal port map (Clk=>Clk, Rst=>Rst, Start=>Start, Save=>Save, Sel=>Sel, S=>S, An=>An, Seg=>Seg, Stop=>Stop);

testBench: process
begin

     Rst<='1';
     wait for clockPeriod;
     Rst<='0';
     wait for clockPeriod;
     S(3 downto 0) <= CONV_STD_LOGIC_VECTOR(1, 4);
     S(7 downto 4) <= CONV_STD_LOGIC_VECTOR(1, 4);
     S(11 downto 8) <= CONV_STD_LOGIC_VECTOR(0,4);
     S(15 downto 12) <= CONV_STD_LOGIC_VECTOR(0, 4);
     wait for clockPeriod;
     Save<='1';
     wait for clockPeriod;
     wait for clockPeriod;
     wait for clockPeriod;
     Save<='0';
     wait for clockPeriod;
     S(3 downto 0) <= CONV_STD_LOGIC_VECTOR(1, 4);
     S(7 downto 4) <= CONV_STD_LOGIC_VECTOR(1, 4);
     S(11 downto 8) <= CONV_STD_LOGIC_VECTOR(9,4);
     S(15 downto 12) <= CONV_STD_LOGIC_VECTOR(0, 4);
     wait for clockPeriod;
     Start<='1';
     wait for clockPeriod;
     Sel<="11";
     wait until Stop='1';
     
     wait;
end process;
end Behavioral;

