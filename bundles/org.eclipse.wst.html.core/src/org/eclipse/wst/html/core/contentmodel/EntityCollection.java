/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.html.core.contentmodel;



import java.lang.reflect.Field;

import org.eclipse.wst.sse.core.internal.contentmodel.CMNode;

/**
 * Factory for entity declarations.
 */
final class EntityCollection extends DeclCollection implements org.eclipse.wst.html.core.HTML40Namespace.EntityName {


	private static class Ids {
		public static final int ID_AACUTE_L = 0;
		public static final int ID_AACUTE_U = 1;
		public static final int ID_ACIRC_L = 2;
		public static final int ID_ACIRC_U = 3;
		public static final int ID_ACUTE = 4;
		public static final int ID_AELIG_L = 5;
		public static final int ID_AELIG_U = 6;
		public static final int ID_AGRAVE_L = 7;
		public static final int ID_AGRAVE_U = 8;
		public static final int ID_ALEFSYM = 9;
		public static final int ID_ALPHA_L = 10;
		public static final int ID_ALPHA_U = 11;
		public static final int ID_AMP = 12;
		public static final int ID_AND = 13;
		public static final int ID_ANG = 14;
		public static final int ID_ARING_L = 15;
		public static final int ID_ARING_U = 16;
		public static final int ID_ASYMP = 17;
		public static final int ID_ATILDE_L = 18;
		public static final int ID_ATILDE_U = 19;
		public static final int ID_AUML_L = 20;
		public static final int ID_AUML_U = 21;
		public static final int ID_BDQUO = 22;
		public static final int ID_BETA_L = 23;
		public static final int ID_BETA_U = 24;
		public static final int ID_BRVBAR = 25;
		public static final int ID_BULL = 26;
		public static final int ID_CAP = 27;
		public static final int ID_CCEDIL_L = 28;
		public static final int ID_CCEDIL_U = 29;
		public static final int ID_CEDIL = 30;
		public static final int ID_CENT = 31;
		public static final int ID_CHI_L = 32;
		public static final int ID_CHI_U = 33;
		public static final int ID_CIRC = 34;
		public static final int ID_CLUBS = 35;
		public static final int ID_CONG = 36;
		public static final int ID_COPY = 37;
		public static final int ID_CRARR = 38;
		public static final int ID_CUP = 39;
		public static final int ID_CURREN = 40;
		public static final int ID_DAGGER_L = 41;
		public static final int ID_DAGGER_U = 42;
		public static final int ID_DARR_L = 43;
		public static final int ID_DARR_U = 44;
		public static final int ID_DEG = 45;
		public static final int ID_DELTA_L = 46;
		public static final int ID_DELTA_U = 47;
		public static final int ID_DIAMS = 48;
		public static final int ID_DIVIDE = 49;
		public static final int ID_EACUTE_L = 50;
		public static final int ID_EACUTE_U = 51;
		public static final int ID_ECIRC_L = 52;
		public static final int ID_ECIRC_U = 53;
		public static final int ID_EGRAVE_L = 54;
		public static final int ID_EGRAVE_U = 55;
		public static final int ID_EMPTY = 56;
		public static final int ID_EMSP = 57;
		public static final int ID_ENSP = 58;
		public static final int ID_EPSILON_L = 59;
		public static final int ID_EPSILON_U = 60;
		public static final int ID_EQUIV = 61;
		public static final int ID_ETA_L = 62;
		public static final int ID_ETA_U = 63;
		public static final int ID_ETH_L = 64;
		public static final int ID_ETH_U = 65;
		public static final int ID_EUML_L = 66;
		public static final int ID_EUML_U = 67;
		public static final int ID_EURO = 68;
		public static final int ID_EXIST = 69;
		public static final int ID_FNOF = 70;
		public static final int ID_FORALL = 71;
		public static final int ID_FRAC12 = 72;
		public static final int ID_FRAC14 = 73;
		public static final int ID_FRAC34 = 74;
		public static final int ID_FRASL = 75;
		public static final int ID_GAMMA_L = 76;
		public static final int ID_GAMMA_U = 77;
		public static final int ID_GE = 78;
		public static final int ID_GT = 79;
		public static final int ID_HARR_L = 80;
		public static final int ID_HARR_U = 81;
		public static final int ID_HEARTS = 82;
		public static final int ID_HELLIP = 83;
		public static final int ID_IACUTE_L = 84;
		public static final int ID_IACUTE_U = 85;
		public static final int ID_ICIRC_L = 86;
		public static final int ID_ICIRC_U = 87;
		public static final int ID_IEXCL = 88;
		public static final int ID_IGRAVE_L = 89;
		public static final int ID_IGRAVE_U = 90;
		public static final int ID_IMAGE = 91;
		public static final int ID_INFIN = 92;
		public static final int ID_INT = 93;
		public static final int ID_IOTA_L = 94;
		public static final int ID_IOTA_U = 95;
		public static final int ID_IQUEST = 96;
		public static final int ID_ISIN = 97;
		public static final int ID_IUML_L = 98;
		public static final int ID_IUML_U = 99;
		public static final int ID_KAPPA_L = 100;
		public static final int ID_KAPPA_U = 101;
		public static final int ID_LAMBDA_L = 102;
		public static final int ID_LAMBDA_U = 103;
		public static final int ID_LANG = 104;
		public static final int ID_LAQUO = 105;
		public static final int ID_LARR_L = 106;
		public static final int ID_LARR_U = 107;
		public static final int ID_LCEIL = 108;
		public static final int ID_LDQUO = 109;
		public static final int ID_LE = 110;
		public static final int ID_LFLOOR = 111;
		public static final int ID_LOWAST = 112;
		public static final int ID_LOZ = 113;
		public static final int ID_LRM = 114;
		public static final int ID_LSAQUO = 115;
		public static final int ID_LSQUO = 116;
		public static final int ID_LT = 117;
		public static final int ID_MACR = 118;
		public static final int ID_MDASH = 119;
		public static final int ID_MICRO = 120;
		public static final int ID_MIDDOT = 121;
		public static final int ID_MINUS = 122;
		public static final int ID_MU_L = 123;
		public static final int ID_MU_U = 124;
		public static final int ID_NABLA = 125;
		public static final int ID_NBSP = 126;
		public static final int ID_NDASH = 127;
		public static final int ID_NE = 128;
		public static final int ID_NI = 129;
		public static final int ID_NOT = 130;
		public static final int ID_NOTIN = 131;
		public static final int ID_NSUB = 132;
		public static final int ID_NTILDE_L = 133;
		public static final int ID_NTILDE_U = 134;
		public static final int ID_NU_L = 135;
		public static final int ID_NU_U = 136;
		public static final int ID_OACUTE_L = 137;
		public static final int ID_OACUTE_U = 138;
		public static final int ID_OCIRC_L = 139;
		public static final int ID_OCIRC_U = 140;
		public static final int ID_OELIG_L = 141;
		public static final int ID_OELIG_U = 142;
		public static final int ID_OGRAVE_L = 143;
		public static final int ID_OGRAVE_U = 144;
		public static final int ID_OLINE = 145;
		public static final int ID_OMEGA_L = 146;
		public static final int ID_OMEGA_U = 147;
		public static final int ID_OMICRON_L = 148;
		public static final int ID_OMICRON_U = 149;
		public static final int ID_OPLUS = 150;
		public static final int ID_OR = 151;
		public static final int ID_ORDF = 152;
		public static final int ID_ORDM = 153;
		public static final int ID_OSLASH_L = 154;
		public static final int ID_OSLASH_U = 155;
		public static final int ID_OTILDE_L = 156;
		public static final int ID_OTILDE_U = 157;
		public static final int ID_OTIMES = 158;
		public static final int ID_OUML_L = 159;
		public static final int ID_OUML_U = 160;
		public static final int ID_PARA = 161;
		public static final int ID_PART = 162;
		public static final int ID_PERMIL = 163;
		public static final int ID_PERP = 164;
		public static final int ID_PHI_L = 165;
		public static final int ID_PHI_U = 166;
		public static final int ID_PIV = 167;
		public static final int ID_PI_L = 168;
		public static final int ID_PI_U = 169;
		public static final int ID_PLUSMN = 170;
		public static final int ID_POUND = 171;
		public static final int ID_PRIME_L = 172;
		public static final int ID_PRIME_U = 173;
		public static final int ID_PROD = 174;
		public static final int ID_PROP = 175;
		public static final int ID_PSI_L = 176;
		public static final int ID_PSI_U = 177;
		public static final int ID_QUOT = 178;
		public static final int ID_RADIC = 179;
		public static final int ID_RANG = 180;
		public static final int ID_RAQUO = 181;
		public static final int ID_RARR_L = 182;
		public static final int ID_RARR_U = 183;
		public static final int ID_RCEIL = 184;
		public static final int ID_RDQUO = 185;
		public static final int ID_REAL = 186;
		public static final int ID_REG = 187;
		public static final int ID_RFLOOR = 188;
		public static final int ID_RHO_L = 189;
		public static final int ID_RHO_U = 190;
		public static final int ID_RLM = 191;
		public static final int ID_RSAQUO = 192;
		public static final int ID_RSQUO = 193;
		public static final int ID_SBQUO = 194;
		public static final int ID_SCARON_L = 195;
		public static final int ID_SCARON_U = 196;
		public static final int ID_SDOT = 197;
		public static final int ID_SECT = 198;
		public static final int ID_SHY = 199;
		public static final int ID_SIGMAF = 200;
		public static final int ID_SIGMA_L = 201;
		public static final int ID_SIGMA_U = 202;
		public static final int ID_SIM = 203;
		public static final int ID_SPADES = 204;
		public static final int ID_SUB = 205;
		public static final int ID_SUBE = 206;
		public static final int ID_SUM = 207;
		public static final int ID_SUP = 208;
		public static final int ID_SUP1 = 209;
		public static final int ID_SUP2 = 210;
		public static final int ID_SUP3 = 211;
		public static final int ID_SUPE = 212;
		public static final int ID_SZLIG = 213;
		public static final int ID_TAU_L = 214;
		public static final int ID_TAU_U = 215;
		public static final int ID_THERE4 = 216;
		public static final int ID_THETASYM = 217;
		public static final int ID_THETA_L = 218;
		public static final int ID_THETA_U = 219;
		public static final int ID_THINSP = 220;
		public static final int ID_THORN_L = 221;
		public static final int ID_THORN_U = 222;
		public static final int ID_TILDE = 223;
		public static final int ID_TIMES = 224;
		public static final int ID_TRADE = 225;
		public static final int ID_UACUTE_L = 226;
		public static final int ID_UACUTE_U = 227;
		public static final int ID_UARR_L = 228;
		public static final int ID_UARR_U = 229;
		public static final int ID_UCIRC_L = 230;
		public static final int ID_UCIRC_U = 231;
		public static final int ID_UGRAVE_L = 232;
		public static final int ID_UGRAVE_U = 233;
		public static final int ID_UML = 234;
		public static final int ID_UPSIH = 235;
		public static final int ID_UPSILON_L = 236;
		public static final int ID_UPSILON_U = 237;
		public static final int ID_UUML_L = 238;
		public static final int ID_UUML_U = 239;
		public static final int ID_WEIERP = 240;
		public static final int ID_XI_L = 241;
		public static final int ID_XI_U = 242;
		public static final int ID_YACUTE_L = 243;
		public static final int ID_YACUTE_U = 244;
		public static final int ID_YEN = 245;
		public static final int ID_YUML_L = 246;
		public static final int ID_YUML_U = 247;
		public static final int ID_ZETA_L = 248;
		public static final int ID_ZETA_U = 249;
		public static final int ID_ZWJ = 250;
		public static final int ID_ZWNJ = 251;

		public static int getNumOfIds() {
			if (numofids != -1)
				return numofids;

			// NOTE: If the reflection is too slow, this method should
			// just return the literal value, like 252.
			// -- 5/24/2001
			Class clazz = Ids.class;
			Field[] fields = clazz.getFields();
			numofids = 0;
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				if (name.startsWith("ID_"))//$NON-NLS-1$
					numofids++;
			}
			return numofids;
		}

		// chache the result of the reflection.
		private static int numofids = -1;
	}

	private static String[] names = null;

	static {
		names = new String[Ids.getNumOfIds()];
		names[Ids.ID_AACUTE_L] = AACUTE_L;
		names[Ids.ID_AACUTE_U] = AACUTE_U;
		names[Ids.ID_ACIRC_L] = ACIRC_L;
		names[Ids.ID_ACIRC_U] = ACIRC_U;
		names[Ids.ID_ACUTE] = ACUTE;
		names[Ids.ID_AELIG_L] = AELIG_L;
		names[Ids.ID_AELIG_U] = AELIG_U;
		names[Ids.ID_AGRAVE_L] = AGRAVE_L;
		names[Ids.ID_AGRAVE_U] = AGRAVE_U;
		names[Ids.ID_ALEFSYM] = ALEFSYM;
		names[Ids.ID_ALPHA_L] = ALPHA_L;
		names[Ids.ID_ALPHA_U] = ALPHA_U;
		names[Ids.ID_AMP] = AMP;
		names[Ids.ID_AND] = AND;
		names[Ids.ID_ANG] = ANG;
		names[Ids.ID_ARING_L] = ARING_L;
		names[Ids.ID_ARING_U] = ARING_U;
		names[Ids.ID_ASYMP] = ASYMP;
		names[Ids.ID_ATILDE_L] = ATILDE_L;
		names[Ids.ID_ATILDE_U] = ATILDE_U;
		names[Ids.ID_AUML_L] = AUML_L;
		names[Ids.ID_AUML_U] = AUML_U;
		names[Ids.ID_BDQUO] = BDQUO;
		names[Ids.ID_BETA_L] = BETA_L;
		names[Ids.ID_BETA_U] = BETA_U;
		names[Ids.ID_BRVBAR] = BRVBAR;
		names[Ids.ID_BULL] = BULL;
		names[Ids.ID_CAP] = CAP;
		names[Ids.ID_CCEDIL_L] = CCEDIL_L;
		names[Ids.ID_CCEDIL_U] = CCEDIL_U;
		names[Ids.ID_CEDIL] = CEDIL;
		names[Ids.ID_CENT] = CENT;
		names[Ids.ID_CHI_L] = CHI_L;
		names[Ids.ID_CHI_U] = CHI_U;
		names[Ids.ID_CIRC] = CIRC;
		names[Ids.ID_CLUBS] = CLUBS;
		names[Ids.ID_CONG] = CONG;
		names[Ids.ID_COPY] = COPY;
		names[Ids.ID_CRARR] = CRARR;
		names[Ids.ID_CUP] = CUP;
		names[Ids.ID_CURREN] = CURREN;
		names[Ids.ID_DAGGER_L] = DAGGER_L;
		names[Ids.ID_DAGGER_U] = DAGGER_U;
		names[Ids.ID_DARR_L] = DARR_L;
		names[Ids.ID_DARR_U] = DARR_U;
		names[Ids.ID_DEG] = DEG;
		names[Ids.ID_DELTA_L] = DELTA_L;
		names[Ids.ID_DELTA_U] = DELTA_U;
		names[Ids.ID_DIAMS] = DIAMS;
		names[Ids.ID_DIVIDE] = DIVIDE;
		names[Ids.ID_EACUTE_L] = EACUTE_L;
		names[Ids.ID_EACUTE_U] = EACUTE_U;
		names[Ids.ID_ECIRC_L] = ECIRC_L;
		names[Ids.ID_ECIRC_U] = ECIRC_U;
		names[Ids.ID_EGRAVE_L] = EGRAVE_L;
		names[Ids.ID_EGRAVE_U] = EGRAVE_U;
		names[Ids.ID_EMPTY] = EMPTY;
		names[Ids.ID_EMSP] = EMSP;
		names[Ids.ID_ENSP] = ENSP;
		names[Ids.ID_EPSILON_L] = EPSILON_L;
		names[Ids.ID_EPSILON_U] = EPSILON_U;
		names[Ids.ID_EQUIV] = EQUIV;
		names[Ids.ID_ETA_L] = ETA_L;
		names[Ids.ID_ETA_U] = ETA_U;
		names[Ids.ID_ETH_L] = ETH_L;
		names[Ids.ID_ETH_U] = ETH_U;
		names[Ids.ID_EUML_L] = EUML_L;
		names[Ids.ID_EUML_U] = EUML_U;
		names[Ids.ID_EURO] = EURO;
		names[Ids.ID_EXIST] = EXIST;
		names[Ids.ID_FNOF] = FNOF;
		names[Ids.ID_FORALL] = FORALL;
		names[Ids.ID_FRAC12] = FRAC12;
		names[Ids.ID_FRAC14] = FRAC14;
		names[Ids.ID_FRAC34] = FRAC34;
		names[Ids.ID_FRASL] = FRASL;
		names[Ids.ID_GAMMA_L] = GAMMA_L;
		names[Ids.ID_GAMMA_U] = GAMMA_U;
		names[Ids.ID_GE] = GE;
		names[Ids.ID_GT] = GT;
		names[Ids.ID_HARR_L] = HARR_L;
		names[Ids.ID_HARR_U] = HARR_U;
		names[Ids.ID_HEARTS] = HEARTS;
		names[Ids.ID_HELLIP] = HELLIP;
		names[Ids.ID_IACUTE_L] = IACUTE_L;
		names[Ids.ID_IACUTE_U] = IACUTE_U;
		names[Ids.ID_ICIRC_L] = ICIRC_L;
		names[Ids.ID_ICIRC_U] = ICIRC_U;
		names[Ids.ID_IEXCL] = IEXCL;
		names[Ids.ID_IGRAVE_L] = IGRAVE_L;
		names[Ids.ID_IGRAVE_U] = IGRAVE_U;
		names[Ids.ID_IMAGE] = IMAGE;
		names[Ids.ID_INFIN] = INFIN;
		names[Ids.ID_INT] = INT;
		names[Ids.ID_IOTA_L] = IOTA_L;
		names[Ids.ID_IOTA_U] = IOTA_U;
		names[Ids.ID_IQUEST] = IQUEST;
		names[Ids.ID_ISIN] = ISIN;
		names[Ids.ID_IUML_L] = IUML_L;
		names[Ids.ID_IUML_U] = IUML_U;
		names[Ids.ID_KAPPA_L] = KAPPA_L;
		names[Ids.ID_KAPPA_U] = KAPPA_U;
		names[Ids.ID_LAMBDA_L] = LAMBDA_L;
		names[Ids.ID_LAMBDA_U] = LAMBDA_U;
		names[Ids.ID_LANG] = LANG;
		names[Ids.ID_LAQUO] = LAQUO;
		names[Ids.ID_LARR_L] = LARR_L;
		names[Ids.ID_LARR_U] = LARR_U;
		names[Ids.ID_LCEIL] = LCEIL;
		names[Ids.ID_LDQUO] = LDQUO;
		names[Ids.ID_LE] = LE;
		names[Ids.ID_LFLOOR] = LFLOOR;
		names[Ids.ID_LOWAST] = LOWAST;
		names[Ids.ID_LOZ] = LOZ;
		names[Ids.ID_LRM] = LRM;
		names[Ids.ID_LSAQUO] = LSAQUO;
		names[Ids.ID_LSQUO] = LSQUO;
		names[Ids.ID_LT] = LT;
		names[Ids.ID_MACR] = MACR;
		names[Ids.ID_MDASH] = MDASH;
		names[Ids.ID_MICRO] = MICRO;
		names[Ids.ID_MIDDOT] = MIDDOT;
		names[Ids.ID_MINUS] = MINUS;
		names[Ids.ID_MU_L] = MU_L;
		names[Ids.ID_MU_U] = MU_U;
		names[Ids.ID_NABLA] = NABLA;
		names[Ids.ID_NBSP] = NBSP;
		names[Ids.ID_NDASH] = NDASH;
		names[Ids.ID_NE] = NE;
		names[Ids.ID_NI] = NI;
		names[Ids.ID_NOT] = NOT;
		names[Ids.ID_NOTIN] = NOTIN;
		names[Ids.ID_NSUB] = NSUB;
		names[Ids.ID_NTILDE_L] = NTILDE_L;
		names[Ids.ID_NTILDE_U] = NTILDE_U;
		names[Ids.ID_NU_L] = NU_L;
		names[Ids.ID_NU_U] = NU_U;
		names[Ids.ID_OACUTE_L] = OACUTE_L;
		names[Ids.ID_OACUTE_U] = OACUTE_U;
		names[Ids.ID_OCIRC_L] = OCIRC_L;
		names[Ids.ID_OCIRC_U] = OCIRC_U;
		names[Ids.ID_OELIG_L] = OELIG_L;
		names[Ids.ID_OELIG_U] = OELIG_U;
		names[Ids.ID_OGRAVE_L] = OGRAVE_L;
		names[Ids.ID_OGRAVE_U] = OGRAVE_U;
		names[Ids.ID_OLINE] = OLINE;
		names[Ids.ID_OMEGA_L] = OMEGA_L;
		names[Ids.ID_OMEGA_U] = OMEGA_U;
		names[Ids.ID_OMICRON_L] = OMICRON_L;
		names[Ids.ID_OMICRON_U] = OMICRON_U;
		names[Ids.ID_OPLUS] = OPLUS;
		names[Ids.ID_OR] = OR;
		names[Ids.ID_ORDF] = ORDF;
		names[Ids.ID_ORDM] = ORDM;
		names[Ids.ID_OSLASH_L] = OSLASH_L;
		names[Ids.ID_OSLASH_U] = OSLASH_U;
		names[Ids.ID_OTILDE_L] = OTILDE_L;
		names[Ids.ID_OTILDE_U] = OTILDE_U;
		names[Ids.ID_OTIMES] = OTIMES;
		names[Ids.ID_OUML_L] = OUML_L;
		names[Ids.ID_OUML_U] = OUML_U;
		names[Ids.ID_PARA] = PARA;
		names[Ids.ID_PART] = PART;
		names[Ids.ID_PERMIL] = PERMIL;
		names[Ids.ID_PERP] = PERP;
		names[Ids.ID_PHI_L] = PHI_L;
		names[Ids.ID_PHI_U] = PHI_U;
		names[Ids.ID_PIV] = PIV;
		names[Ids.ID_PI_L] = PI_L;
		names[Ids.ID_PI_U] = PI_U;
		names[Ids.ID_PLUSMN] = PLUSMN;
		names[Ids.ID_POUND] = POUND;
		names[Ids.ID_PRIME_L] = PRIME_L;
		names[Ids.ID_PRIME_U] = PRIME_U;
		names[Ids.ID_PROD] = PROD;
		names[Ids.ID_PROP] = PROP;
		names[Ids.ID_PSI_L] = PSI_L;
		names[Ids.ID_PSI_U] = PSI_U;
		names[Ids.ID_QUOT] = QUOT;
		names[Ids.ID_RADIC] = RADIC;
		names[Ids.ID_RANG] = RANG;
		names[Ids.ID_RAQUO] = RAQUO;
		names[Ids.ID_RARR_L] = RARR_L;
		names[Ids.ID_RARR_U] = RARR_U;
		names[Ids.ID_RCEIL] = RCEIL;
		names[Ids.ID_RDQUO] = RDQUO;
		names[Ids.ID_REAL] = REAL;
		names[Ids.ID_REG] = REG;
		names[Ids.ID_RFLOOR] = RFLOOR;
		names[Ids.ID_RHO_L] = RHO_L;
		names[Ids.ID_RHO_U] = RHO_U;
		names[Ids.ID_RLM] = RLM;
		names[Ids.ID_RSAQUO] = RSAQUO;
		names[Ids.ID_RSQUO] = RSQUO;
		names[Ids.ID_SBQUO] = SBQUO;
		names[Ids.ID_SCARON_L] = SCARON_L;
		names[Ids.ID_SCARON_U] = SCARON_U;
		names[Ids.ID_SDOT] = SDOT;
		names[Ids.ID_SECT] = SECT;
		names[Ids.ID_SHY] = SHY;
		names[Ids.ID_SIGMAF] = SIGMAF;
		names[Ids.ID_SIGMA_L] = SIGMA_L;
		names[Ids.ID_SIGMA_U] = SIGMA_U;
		names[Ids.ID_SIM] = SIM;
		names[Ids.ID_SPADES] = SPADES;
		names[Ids.ID_SUB] = SUB;
		names[Ids.ID_SUBE] = SUBE;
		names[Ids.ID_SUM] = SUM;
		names[Ids.ID_SUP] = SUP;
		names[Ids.ID_SUP1] = SUP1;
		names[Ids.ID_SUP2] = SUP2;
		names[Ids.ID_SUP3] = SUP3;
		names[Ids.ID_SUPE] = SUPE;
		names[Ids.ID_SZLIG] = SZLIG;
		names[Ids.ID_TAU_L] = TAU_L;
		names[Ids.ID_TAU_U] = TAU_U;
		names[Ids.ID_THERE4] = THERE4;
		names[Ids.ID_THETASYM] = THETASYM;
		names[Ids.ID_THETA_L] = THETA_L;
		names[Ids.ID_THETA_U] = THETA_U;
		names[Ids.ID_THINSP] = THINSP;
		names[Ids.ID_THORN_L] = THORN_L;
		names[Ids.ID_THORN_U] = THORN_U;
		names[Ids.ID_TILDE] = TILDE;
		names[Ids.ID_TIMES] = TIMES;
		names[Ids.ID_TRADE] = TRADE;
		names[Ids.ID_UACUTE_L] = UACUTE_L;
		names[Ids.ID_UACUTE_U] = UACUTE_U;
		names[Ids.ID_UARR_L] = UARR_L;
		names[Ids.ID_UARR_U] = UARR_U;
		names[Ids.ID_UCIRC_L] = UCIRC_L;
		names[Ids.ID_UCIRC_U] = UCIRC_U;
		names[Ids.ID_UGRAVE_L] = UGRAVE_L;
		names[Ids.ID_UGRAVE_U] = UGRAVE_U;
		names[Ids.ID_UML] = UML;
		names[Ids.ID_UPSIH] = UPSIH;
		names[Ids.ID_UPSILON_L] = UPSILON_L;
		names[Ids.ID_UPSILON_U] = UPSILON_U;
		names[Ids.ID_UUML_L] = UUML_L;
		names[Ids.ID_UUML_U] = UUML_U;
		names[Ids.ID_WEIERP] = WEIERP;
		names[Ids.ID_XI_L] = XI_L;
		names[Ids.ID_XI_U] = XI_U;
		names[Ids.ID_YACUTE_L] = YACUTE_L;
		names[Ids.ID_YACUTE_U] = YACUTE_U;
		names[Ids.ID_YEN] = YEN;
		names[Ids.ID_YUML_L] = YUML_L;
		names[Ids.ID_YUML_U] = YUML_U;
		names[Ids.ID_ZETA_L] = ZETA_L;
		names[Ids.ID_ZETA_U] = ZETA_U;
		names[Ids.ID_ZWJ] = ZWJ;
		names[Ids.ID_ZWNJ] = ZWNJ;
	}
	private static char[] values = null;

	static {
		values = new char[Ids.getNumOfIds()];
		values[Ids.ID_AACUTE_L] = 225;
		values[Ids.ID_AACUTE_U] = 193;
		values[Ids.ID_ACIRC_L] = 226;
		values[Ids.ID_ACIRC_U] = 194;
		values[Ids.ID_ACUTE] = 180;
		values[Ids.ID_AELIG_L] = 230;
		values[Ids.ID_AELIG_U] = 198;
		values[Ids.ID_AGRAVE_L] = 224;
		values[Ids.ID_AGRAVE_U] = 192;
		values[Ids.ID_ALEFSYM] = 8501;
		values[Ids.ID_ALPHA_L] = 945;
		values[Ids.ID_ALPHA_U] = 913;
		values[Ids.ID_AMP] = 38;
		values[Ids.ID_AND] = 8743;
		values[Ids.ID_ANG] = 8736;
		values[Ids.ID_ARING_L] = 229;
		values[Ids.ID_ARING_U] = 197;
		values[Ids.ID_ASYMP] = 8776;
		values[Ids.ID_ATILDE_L] = 227;
		values[Ids.ID_ATILDE_U] = 195;
		values[Ids.ID_AUML_L] = 228;
		values[Ids.ID_AUML_U] = 196;
		values[Ids.ID_BDQUO] = 8222;
		values[Ids.ID_BETA_L] = 946;
		values[Ids.ID_BETA_U] = 914;
		values[Ids.ID_BRVBAR] = 166;
		values[Ids.ID_BULL] = 8226;
		values[Ids.ID_CAP] = 8745;
		values[Ids.ID_CCEDIL_L] = 231;
		values[Ids.ID_CCEDIL_U] = 199;
		values[Ids.ID_CEDIL] = 184;
		values[Ids.ID_CENT] = 162;
		values[Ids.ID_CHI_L] = 967;
		values[Ids.ID_CHI_U] = 935;
		values[Ids.ID_CIRC] = 710;
		values[Ids.ID_CLUBS] = 9827;
		values[Ids.ID_CONG] = 8773;
		values[Ids.ID_COPY] = 169;
		values[Ids.ID_CRARR] = 8629;
		values[Ids.ID_CUP] = 8746;
		values[Ids.ID_CURREN] = 164;
		values[Ids.ID_DAGGER_L] = 8224;
		values[Ids.ID_DAGGER_U] = 8225;
		values[Ids.ID_DARR_L] = 8595;
		values[Ids.ID_DARR_U] = 8659;
		values[Ids.ID_DEG] = 176;
		values[Ids.ID_DELTA_L] = 948;
		values[Ids.ID_DELTA_U] = 916;
		values[Ids.ID_DIAMS] = 9830;
		values[Ids.ID_DIVIDE] = 247;
		values[Ids.ID_EACUTE_L] = 233;
		values[Ids.ID_EACUTE_U] = 201;
		values[Ids.ID_ECIRC_L] = 234;
		values[Ids.ID_ECIRC_U] = 202;
		values[Ids.ID_EGRAVE_L] = 232;
		values[Ids.ID_EGRAVE_U] = 200;
		values[Ids.ID_EMPTY] = 8709;
		values[Ids.ID_EMSP] = 8195;
		values[Ids.ID_ENSP] = 8194;
		values[Ids.ID_EPSILON_L] = 949;
		values[Ids.ID_EPSILON_U] = 917;
		values[Ids.ID_EQUIV] = 8801;
		values[Ids.ID_ETA_L] = 951;
		values[Ids.ID_ETA_U] = 919;
		values[Ids.ID_ETH_L] = 240;
		values[Ids.ID_ETH_U] = 208;
		values[Ids.ID_EUML_L] = 235;
		values[Ids.ID_EUML_U] = 203;
		values[Ids.ID_EURO] = 8364;
		values[Ids.ID_EXIST] = 8707;
		values[Ids.ID_FNOF] = 402;
		values[Ids.ID_FORALL] = 8704;
		values[Ids.ID_FRAC12] = 189;
		values[Ids.ID_FRAC14] = 188;
		values[Ids.ID_FRAC34] = 190;
		values[Ids.ID_FRASL] = 8260;
		values[Ids.ID_GAMMA_L] = 947;
		values[Ids.ID_GAMMA_U] = 915;
		values[Ids.ID_GE] = 8805;
		values[Ids.ID_GT] = 62;
		values[Ids.ID_HARR_L] = 8596;
		values[Ids.ID_HARR_U] = 8660;
		values[Ids.ID_HEARTS] = 9829;
		values[Ids.ID_HELLIP] = 8230;
		values[Ids.ID_IACUTE_L] = 237;
		values[Ids.ID_IACUTE_U] = 205;
		values[Ids.ID_ICIRC_L] = 238;
		values[Ids.ID_ICIRC_U] = 206;
		values[Ids.ID_IEXCL] = 161;
		values[Ids.ID_IGRAVE_L] = 236;
		values[Ids.ID_IGRAVE_U] = 204;
		values[Ids.ID_IMAGE] = 8465;
		values[Ids.ID_INFIN] = 8734;
		values[Ids.ID_INT] = 8747;
		values[Ids.ID_IOTA_L] = 953;
		values[Ids.ID_IOTA_U] = 921;
		values[Ids.ID_IQUEST] = 191;
		values[Ids.ID_ISIN] = 8712;
		values[Ids.ID_IUML_L] = 239;
		values[Ids.ID_IUML_U] = 207;
		values[Ids.ID_KAPPA_L] = 954;
		values[Ids.ID_KAPPA_U] = 922;
		values[Ids.ID_LAMBDA_L] = 955;
		values[Ids.ID_LAMBDA_U] = 923;
		values[Ids.ID_LANG] = 9001;
		values[Ids.ID_LAQUO] = 171;
		values[Ids.ID_LARR_L] = 8592;
		values[Ids.ID_LARR_U] = 8656;
		values[Ids.ID_LCEIL] = 8968;
		values[Ids.ID_LDQUO] = 8220;
		values[Ids.ID_LE] = 8804;
		values[Ids.ID_LFLOOR] = 8970;
		values[Ids.ID_LOWAST] = 8727;
		values[Ids.ID_LOZ] = 9674;
		values[Ids.ID_LRM] = 8206;
		values[Ids.ID_LSAQUO] = 8249;
		values[Ids.ID_LSQUO] = 8216;
		values[Ids.ID_LT] = 60;
		values[Ids.ID_MACR] = 175;
		values[Ids.ID_MDASH] = 8212;
		values[Ids.ID_MICRO] = 181;
		values[Ids.ID_MIDDOT] = 183;
		values[Ids.ID_MINUS] = 8722;
		values[Ids.ID_MU_L] = 956;
		values[Ids.ID_MU_U] = 924;
		values[Ids.ID_NABLA] = 8711;
		values[Ids.ID_NBSP] = 160;
		values[Ids.ID_NDASH] = 8211;
		values[Ids.ID_NE] = 8800;
		values[Ids.ID_NI] = 8715;
		values[Ids.ID_NOT] = 172;
		values[Ids.ID_NOTIN] = 8713;
		values[Ids.ID_NSUB] = 8836;
		values[Ids.ID_NTILDE_L] = 241;
		values[Ids.ID_NTILDE_U] = 209;
		values[Ids.ID_NU_L] = 957;
		values[Ids.ID_NU_U] = 925;
		values[Ids.ID_OACUTE_L] = 243;
		values[Ids.ID_OACUTE_U] = 211;
		values[Ids.ID_OCIRC_L] = 244;
		values[Ids.ID_OCIRC_U] = 212;
		values[Ids.ID_OELIG_L] = 339;
		values[Ids.ID_OELIG_U] = 338;
		values[Ids.ID_OGRAVE_L] = 242;
		values[Ids.ID_OGRAVE_U] = 210;
		values[Ids.ID_OLINE] = 8254;
		values[Ids.ID_OMEGA_L] = 969;
		values[Ids.ID_OMEGA_U] = 937;
		values[Ids.ID_OMICRON_L] = 959;
		values[Ids.ID_OMICRON_U] = 927;
		values[Ids.ID_OPLUS] = 8853;
		values[Ids.ID_OR] = 8744;
		values[Ids.ID_ORDF] = 170;
		values[Ids.ID_ORDM] = 186;
		values[Ids.ID_OSLASH_L] = 248;
		values[Ids.ID_OSLASH_U] = 216;
		values[Ids.ID_OTILDE_L] = 245;
		values[Ids.ID_OTILDE_U] = 213;
		values[Ids.ID_OTIMES] = 8855;
		values[Ids.ID_OUML_L] = 246;
		values[Ids.ID_OUML_U] = 214;
		values[Ids.ID_PARA] = 182;
		values[Ids.ID_PART] = 8706;
		values[Ids.ID_PERMIL] = 8240;
		values[Ids.ID_PERP] = 8869;
		values[Ids.ID_PHI_L] = 966;
		values[Ids.ID_PHI_U] = 934;
		values[Ids.ID_PIV] = 982;
		values[Ids.ID_PI_L] = 960;
		values[Ids.ID_PI_U] = 928;
		values[Ids.ID_PLUSMN] = 177;
		values[Ids.ID_POUND] = 163;
		values[Ids.ID_PRIME_L] = 8242;
		values[Ids.ID_PRIME_U] = 8243;
		values[Ids.ID_PROD] = 8719;
		values[Ids.ID_PROP] = 8733;
		values[Ids.ID_PSI_L] = 968;
		values[Ids.ID_PSI_U] = 936;
		values[Ids.ID_QUOT] = 34;
		values[Ids.ID_RADIC] = 8730;
		values[Ids.ID_RANG] = 9002;
		values[Ids.ID_RAQUO] = 187;
		values[Ids.ID_RARR_L] = 8594;
		values[Ids.ID_RARR_U] = 8658;
		values[Ids.ID_RCEIL] = 8969;
		values[Ids.ID_RDQUO] = 8221;
		values[Ids.ID_REAL] = 8476;
		values[Ids.ID_REG] = 174;
		values[Ids.ID_RFLOOR] = 8971;
		values[Ids.ID_RHO_L] = 961;
		values[Ids.ID_RHO_U] = 929;
		values[Ids.ID_RLM] = 8207;
		values[Ids.ID_RSAQUO] = 8250;
		values[Ids.ID_RSQUO] = 8217;
		values[Ids.ID_SBQUO] = 8218;
		values[Ids.ID_SCARON_L] = 353;
		values[Ids.ID_SCARON_U] = 352;
		values[Ids.ID_SDOT] = 8901;
		values[Ids.ID_SECT] = 167;
		values[Ids.ID_SHY] = 173;
		values[Ids.ID_SIGMAF] = 962;
		values[Ids.ID_SIGMA_L] = 963;
		values[Ids.ID_SIGMA_U] = 931;
		values[Ids.ID_SIM] = 8764;
		values[Ids.ID_SPADES] = 9824;
		values[Ids.ID_SUB] = 8834;
		values[Ids.ID_SUBE] = 8838;
		values[Ids.ID_SUM] = 8721;
		values[Ids.ID_SUP] = 8835;
		values[Ids.ID_SUP1] = 185;
		values[Ids.ID_SUP2] = 178;
		values[Ids.ID_SUP3] = 179;
		values[Ids.ID_SUPE] = 8839;
		values[Ids.ID_SZLIG] = 223;
		values[Ids.ID_TAU_L] = 964;
		values[Ids.ID_TAU_U] = 932;
		values[Ids.ID_THERE4] = 8756;
		values[Ids.ID_THETASYM] = 977;
		values[Ids.ID_THETA_L] = 952;
		values[Ids.ID_THETA_U] = 920;
		values[Ids.ID_THINSP] = 8201;
		values[Ids.ID_THORN_L] = 254;
		values[Ids.ID_THORN_U] = 222;
		values[Ids.ID_TILDE] = 732;
		values[Ids.ID_TIMES] = 215;
		values[Ids.ID_TRADE] = 8482;
		values[Ids.ID_UACUTE_L] = 250;
		values[Ids.ID_UACUTE_U] = 218;
		values[Ids.ID_UARR_L] = 8593;
		values[Ids.ID_UARR_U] = 8657;
		values[Ids.ID_UCIRC_L] = 251;
		values[Ids.ID_UCIRC_U] = 219;
		values[Ids.ID_UGRAVE_L] = 249;
		values[Ids.ID_UGRAVE_U] = 217;
		values[Ids.ID_UML] = 168;
		values[Ids.ID_UPSIH] = 978;
		values[Ids.ID_UPSILON_L] = 965;
		values[Ids.ID_UPSILON_U] = 933;
		values[Ids.ID_UUML_L] = 252;
		values[Ids.ID_UUML_U] = 220;
		values[Ids.ID_WEIERP] = 8472;
		values[Ids.ID_XI_L] = 958;
		values[Ids.ID_XI_U] = 926;
		values[Ids.ID_YACUTE_L] = 253;
		values[Ids.ID_YACUTE_U] = 221;
		values[Ids.ID_YEN] = 165;
		values[Ids.ID_YUML_L] = 255;
		values[Ids.ID_YUML_U] = 376;
		values[Ids.ID_ZETA_L] = 950;
		values[Ids.ID_ZETA_U] = 918;
		values[Ids.ID_ZWJ] = 8205;
		values[Ids.ID_ZWNJ] = 8204;
	}

	/**
	 */
	public EntityCollection() {
		super(names, STRICT_CASE);
	}

	/**
	 * Create an entity declaration.
	 * @return org.eclipse.wst.sse.core.internal.contentmodel.CMNode
	 * @param attrName java.lang.String
	 */
	protected CMNode create(String entityName) {
		int id = getID(entityName);
		if (id == ID_UNKNOWN)
			return null;

		String value = String.valueOf(values[id]);
		HTMLEntityDeclImpl dec = new HTMLEntityDeclImpl(entityName, value);

		return dec;
	}
}